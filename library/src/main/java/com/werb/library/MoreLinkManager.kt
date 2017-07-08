package com.werb.library

import android.support.v4.util.SparseArrayCompat
import android.util.Log
import kotlin.reflect.KClass


/**
 * Created by wanbo on 2017/7/5.
 */
class MoreLinkManager : MoreLink {

    private val TAG = "MoreLinkManager"

    private var viewTypeMap = SparseArrayCompat<MoreViewType<Any, MoreViewHolder>>()
    private var modelTypeMap = SparseArrayCompat<KClass<out Any>>()

    override fun register(viewType: MoreViewType<*, *>): MoreLink {
        val type = viewType.getViewLayout()
        val model = viewType.getViewModel()
        if(modelTypeMap[type] != null){
            val modelName = model.simpleName
            val typeName = type.javaClass.simpleName
            Log.d(TAG, "model: $modelName will replace link with $typeName")
        }
        viewTypeMap.put(type, viewType as MoreViewType<Any, MoreViewHolder>?)
        modelTypeMap.put(type, model)
        return this
    }

    override fun attachViewType(clazz: KClass<out Any>): MoreViewType<Any, MoreViewHolder> {
        val type = modelTypeMap.indexOfValue(clazz)
        if (type == -1){
            throw ModelNotRegisterException(clazz.simpleName as String)
        }
        val key = viewTypeMap.keyAt(type)
        return viewTypeMap[key]
    }

    override fun buildViewType(type: Int): MoreViewType<Any, MoreViewHolder> {
        if (type == -1) {
            throw  NullPointerException("no such type!")
        }
        return viewTypeMap[type]
    }



}