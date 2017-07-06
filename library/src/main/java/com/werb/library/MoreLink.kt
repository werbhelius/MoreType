package com.werb.library


/**
 * [MoreLink] link model and view
 * Created by wanbo on 2017/7/2.
 */
interface MoreLink {

    /** [register]  register viewType when we use */
    fun <T : Any, V: MoreViewHolder> register(viewType: MoreViewType<T, V>): MoreLink

    fun <T : Any, V: MoreViewHolder> attachViewType(clazz: Class<Any>) : MoreViewType<T, V>

}