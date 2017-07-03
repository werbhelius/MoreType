package com.werb.library

import android.view.LayoutInflater
import android.view.ViewGroup
import com.werb.library.action.MoreAction

/**
 * [MoreViewType] link with model
 * Created by wanbo on 2017/7/2.
 */
abstract class MoreViewType<in T, V: MoreViewHolder>: MoreAction() {

    /** [getViewLayout] is unique and will help to build link */
    abstract fun getViewLayout(): Int

    /** [onCreateViewHolder] just list onCreateViewHolder() in RecyclerView.Adapter  */
    abstract fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): V

    /** [onBindViewHolder] just list onBindViewHolder() in RecyclerView.Adapter  */
    abstract fun onBindViewHolder(holder: V, t: T)

}