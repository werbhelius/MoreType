package com.werb.library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.werb.library.action.MoreAction

/**
 * [MoreViewType] link with model
 * Created by wanbo on 2017/7/2.
 */
abstract class MoreViewType<in T, V: MoreViewHolder>: MoreAction() {

    private var holder: V? = null

    open fun build(holder: V){
        this.holder = holder
        holder.setActionListener(this)
    }

    override fun getChildView(viewId: Int): View? {
        return holder?.getChildView(viewId)
    }

    /** [getViewLayout] is unique and will help to build link */
    abstract fun getViewLayout(): Int

    /** [onCreateViewHolder] just list onCreateViewHolder() in RecyclerView.Adapter  */
    abstract fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): V

    /** [onBindViewHolder] just list onBindViewHolder() in RecyclerView.Adapter  */
    abstract fun onBindViewHolder(holder: V, t: T)

}