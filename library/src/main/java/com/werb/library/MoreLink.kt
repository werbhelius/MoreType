package com.werb.library

import android.support.v7.widget.RecyclerView
import kotlin.reflect.KClass


/**
 * [MoreLink] link model and view
 * Created by wanbo on 2017/7/2.
 */
interface MoreLink {

    /** [register]  register viewType when we use */
    fun register(viewType: MoreViewType<*, *>): MoreLink

    fun attachViewType(clazz: KClass<out Any>) : MoreViewType<Any, MoreViewHolder>

    fun buildViewType(type: Int) : MoreViewType<Any, MoreViewHolder>

}