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
        viewTypeMap.put(type, viewType as MoreViewType<Any>?)
        modelTypeMap.put(type, model)
        return this
    }

    override fun attachViewType(clazz: KClass<out Any>): MoreViewType<Any> {
        val type = modelTypeMap.indexOfValue(clazz)
        if (type == -1){
            throw ModelNotRegisterException(clazz.simpleName as String)
        }
        val key = viewTypeMap.keyAt(type)
        return viewTypeMap[key]
    }

    override fun buildViewType(type: Int): MoreViewType<Any> {
        if (type == -1) {
            throw  NullPointerException("no such type!")
        }
        return viewTypeMap[type]
    }



}