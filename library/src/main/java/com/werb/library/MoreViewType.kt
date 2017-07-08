package com.werb.library

import android.view.LayoutInflater
import android.view.ViewGroup
import com.werb.library.action.MoreAction
import kotlin.reflect.KClass


/**
 * [MoreViewType] link with model
 * Created by wanbo on 2017/7/2.
 */
abstract class MoreViewType<T : Any, V: MoreViewHolder>: MoreAction() {

    /** [getViewLayout] is unique and will help to build link */
    abstract fun getViewLayout(): Int

    /** [getViewModel] model link with viewType */
    abstract fun  getViewModel(): KClass<T>

    /** [onCreateViewHolder] just list onCreateViewHolder() in RecyclerView.Adapter  */
    abstract fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): V

    /** [onBindViewHolder] just list onBindViewHolder() in RecyclerView.Adapter  */
    abstract fun onBindViewHolder(holder: V, t: T)

}