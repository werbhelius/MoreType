package com.werb.library

import android.util.Log


/**
 * Created by wanbo on 2017/7/5.
 */
class MoreLinkManager : MoreLink {

    private val TAG = "MoreLinkManager"

    private var viewTypeMap = mutableMapOf<Any, MoreViewType<*, *>>()

    override fun <T : Any, V : MoreViewHolder> register(viewType: MoreViewType<T, V>): MoreLink {
        val model = viewType.getViewModel()
        val type = viewTypeMap[model]
        if (type != null) {
            val modelName = model.simpleName
            val typeName = type.javaClass.simpleName
            Log.d(TAG, "model: $modelName will replace link with $typeName")
        }
        viewTypeMap.put(viewType.getViewModel(), viewType)
        return this
    }

    override fun <T : Any, V : MoreViewHolder> attachViewType(clazz: Class<Any>): MoreViewType<T, V> {
        val moreViewType = viewTypeMap[clazz]
        val viewType = moreViewType?.let {
            it
        } ?: throw ModelNotRegisterException(clazz.simpleName as String)
        return viewType as MoreViewType<T, V>
    }
}