package com.werb.library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.werb.library.action.MoreAction
import kotlin.reflect.KClass


/**
 * [MoreViewType] link with model
 * Created by wanbo on 2017/7/2.
 */
abstract class MoreViewType<T: Any>(internal val layoutId: Int,
                                     internal val clazz: KClass<T>): MoreAction() {
    /** [initView] find view  */
    abstract fun initView(holder: MoreViewHolder)

    /** [bindData] bind data with T  */
    abstract fun bindData(data: T, holder: MoreViewHolder)

    /** [unBindData] unbind and release resources*/
    open fun unBindData(holder: MoreViewHolder){}

    /** [onCreateViewHolder] just like onCreateViewHolder() in RecyclerView.Adapter  */
    fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): MoreViewHolder{
        val view = inflater.inflate(layoutId, parent, false)
        val moreViewHolder = MoreViewHolder(view)
        return moreViewHolder
    }

}