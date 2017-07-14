package com.werb.library

import android.view.LayoutInflater
import android.view.ViewGroup
import com.werb.library.action.MoreAction
import kotlin.reflect.KClass


/**
 * [MoreViewType] link with model
 * Created by wanbo on 2017/7/2.
 */
abstract class MoreViewType<T : Any>: MoreAction() {

    /** [getViewLayout] is unique and will help to build link */
    abstract fun getViewLayout(): Int

    /** [getViewModel] model link with viewType */
    abstract fun  getViewModel(): KClass<T>

    /** [bindData] bind data with T  */
    abstract fun bindData(data: T, holder: MoreViewHolder)

    /** [onCreateViewHolder] just like onCreateViewHolder() in RecyclerView.Adapter  */
    fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): MoreViewHolder{
        val view = inflater.inflate(getViewLayout(), parent, false)
        return MoreViewHolder(view)
    }

}