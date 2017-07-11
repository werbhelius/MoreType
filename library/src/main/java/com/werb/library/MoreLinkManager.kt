package com.werb.library

import android.support.v4.util.SparseArrayCompat
import android.util.Log
import kotlin.reflect.KClass


/**
 * Created by wanbo on 2017/7/5.
 */
class MoreLinkManager : MoreLink {

    private val TAG = "MoreType"
    private var viewTypeMap = SparseArrayCompat<MoreViewType<Any>>()
    private var modelTypeMap = SparseArrayCompat<KClass<out Any>>()
    private var multiModelMap = mutableMapOf<KClass<*>, MultiLink<Any>>()
        private set

    override fun register(viewType: MoreViewType<*>): MoreLink {
        val type = viewType.getViewLayout()
        val model = viewType.getViewModel()
        if(modelTypeMap.indexOfValue(model) != -1){
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
        return this
    }

    override fun multiRegister(clazz: KClass<*>, link: MultiLink<*>): MoreLink {
        @Suppress("UNCHECKED_CAST")
        multiModelMap.put(clazz, link as MultiLink<Any>)
        return this
    }

    override fun attachViewTypeLayout(any: Any): Int {
        val clazz = any::class
        val type = modelTypeMap.indexOfValue(clazz)
        if (type == -1){
            val multiClazz = multiModelMap.containsKey(clazz)
            if(multiClazz){
                return -1
            }else {
                throw ModelNotRegisterException(clazz.simpleName as String)
            }
        }
        val key = viewTypeMap.keyAt(type)
        return viewTypeMap[key].getViewLayout()
    }

    override fun attachViewType(any: Any): MoreViewType<Any> {
        val clazz = any::class
        val type = modelTypeMap.indexOfValue(clazz)
        if (type == -1){
            val multiClazz = multiModelMap.containsKey(clazz)
            if(multiClazz){
                val multiLink = multiModelMap[clazz]
                val moreViewType = multiLink?.link(any) as MoreViewType<Any>
                return moreViewType
            }else {
                throw ModelNotRegisterException(clazz.simpleName as String)
            }
        } else {
            val key = viewTypeMap.keyAt(type)
            return viewTypeMap[key]
        }
    }

    override fun buildViewType(type: Int): MoreViewType<Any>? {
        if (type == -1) {
            throw  NullPointerException("no such type!")
        }
        return viewTypeMap[type]
    }


}