package com.werb.library.link

import android.support.v4.util.SparseArrayCompat
import android.util.Log
import com.werb.library.MoreAdapter
import com.werb.library.MoreViewType
import com.werb.library.exception.ModelNotRegisterException
import com.werb.library.exception.MultiModelNotRegisterException
import kotlin.reflect.KClass


/**
 * Data driven view
 * layout is unique, so we uses layout to link data and view
 * layout id is unique key
 * Created by wanbo on 2017/7/5.
 */
class MoreLinkManager(var adapter: MoreAdapter) : MoreLink {

    private val TAG = "MoreType"

    /** [viewTypeMap] save MoreViewType by layout id */
    private var viewTypeMap = SparseArrayCompat<MoreViewType<Any>>()

    /** [modelTypeMap] save Data::class by layout id */
    private var modelTypeMap = SparseArrayCompat<Class<*>>()

    /** [multiModelMap] save [MultiLink] by Data::class */
    private var multiModelMap = mutableMapOf<Class<*>, MultiLink<Any>>()

    /** [multiViewTypeMap] save MoreViewType by layout id */
    private var multiViewTypeMap = SparseArrayCompat<MoreViewType<Any>>()

    /**
     *  [register] register single MoreViewType , MoreViewType can't repeat
     *  if two ViewType's getViewModel() return same Data::class
     *  [viewTypeMap] and [modelTypeMap] will remove oldViewType and replace by newViewType
     */
    override fun register(viewType: MoreViewType<*>): MoreAdapter {
        val type = viewType.layoutId
        val model = viewType.clazz
        if (modelTypeMap.indexOfValue(model) != -1) {
            val index = modelTypeMap.indexOfValue(model)
            val key = viewTypeMap.keyAt(index)
            val oldViewType = viewTypeMap[key]
            val modelName = model.simpleName
            val newTypeName = viewType.javaClass.simpleName
            val oldViewTypeName = oldViewType.javaClass.simpleName
            viewTypeMap.removeAt(index)
            modelTypeMap.removeAt(index)
            Log.w(TAG, "model repeated! $modelName.class will replace $oldViewTypeName to $newTypeName")
        }
        @Suppress("UNCHECKED_CAST")
        viewTypeMap.put(type, viewType as MoreViewType<Any>?)
        modelTypeMap.put(type, model)
        return adapter
    }

    /**
     * [multiRegister] register multi MoreViewType
     * [clazz] which data will multi register
     * [link] the link between data and kinds of viewType
     * use map save , so same class will be replace, if you register repeated
     */
    override fun multiRegister(clazz: KClass<*>, link: MultiLink<*>): MoreAdapter {
        @Suppress("UNCHECKED_CAST")
        multiModelMap.put(clazz.java, link as MultiLink<Any>)
        return adapter
    }

    override fun multiRegister(clazz: Class<*>, link: MultiLink<*>): MoreAdapter {
        @Suppress("UNCHECKED_CAST")
        multiModelMap.put(clazz, link as MultiLink<Any>)
        return adapter
    }

    /**
     * [attachViewTypeLayout] attach to viewType' layout by data item
     * if data belong to single register will return viewType's unique key (layout)
     * if data belong to multi register will return -1
     * if data not register will throw [ModelNotRegisterException]
     */
    override fun attachViewTypeLayout(any: Any): Int {
        val clazz = any.javaClass
        val type = modelTypeMap.indexOfValue(clazz)
        if (type == -1) {
            val multiClazz = multiModelMap.containsKey(clazz)
            if (multiClazz) {
                val multiLink = multiModelMap[clazz]
                val viewType = multiLink?.link(any)
                if (viewType != null) {
                    if (multiViewTypeMap.get(viewType.layoutId) == null) {
                        multiViewTypeMap.put(viewType.layoutId, viewType)
                    }
                    return viewType.layoutId
                }
            } else {
                throw ModelNotRegisterException(clazz.simpleName as String)
            }
        }
        return viewTypeMap.keyAt(type)
    }

    /**
     * [attachViewType] attach to viewType by data item
     * if data belong to single register will return viewType
     * if data belong to multi register will return viewType by multiLink judge data
     * if data belong to multi register, but not link viewType with multiLink will throw [MultiModelNotRegisterException]
     * if data not register will throw [ModelNotRegisterException]
     */
    override fun attachViewType(any: Any): MoreViewType<Any> {
        val clazz = any.javaClass
        val type = modelTypeMap.indexOfValue(clazz)
        if (type == -1) {
            val multiClazz = multiModelMap.containsKey(clazz)
            if (multiClazz) {
                val multiLink = multiModelMap[clazz]
                val viewType = multiLink?.link(any)
                if (viewType != null) {
                    return multiViewTypeMap[viewType.layoutId]
                } else {
                    throw MultiModelNotRegisterException(clazz.simpleName as String)
                }
            } else {
                throw ModelNotRegisterException(clazz.simpleName as String)
            }
        } else {
            val key = viewTypeMap.keyAt(type)
            return viewTypeMap[key]
        }
    }

    /** [buildViewType] return MoreViewType in onCreateViewHolder() to create viewHolder*/
    override fun buildViewType(type: Int): MoreViewType<Any>?{
        if (type == -1) {
            throw  NullPointerException("no such type!")
        }

        val viewType = viewTypeMap[type]
        val multiViewType = multiViewTypeMap[type]

        if (viewType != null){
            return viewType
        }

        if (multiViewType != null){
            return multiViewType
        }

        throw  NullPointerException("no such type!")
    }

    /** [userSoleRegister] single register Global ViewType */
    override fun userSoleRegister(): MoreAdapter {
        val viewTypes = SoleLinkManager.viewTypes
        for (viewType in viewTypes) {
            register(viewType)
        }
        return adapter
    }

}