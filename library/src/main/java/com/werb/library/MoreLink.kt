package com.werb.library

/**
 * [MoreLink] link model and view
 * Created by wanbo on 2017/7/2.
 */
interface MoreLink {

    fun <T, V: MoreViewHolder> register(clazz: Class<Any>, viewType: MoreViewType<T, V>)

}