package com.werb.library

import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup

/**
 * [MoreAdapter] build viewHolder with data
 * Created by wanbo on 2017/7/2.
 */
class MoreAdapter : Adapter<ViewHolder>(), MoreLink {

    var list: List<Any> = mutableListOf()
        private set

    private val linkManager: MoreLink = MoreLinkManager()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        val any = list[position]
        return attachViewType<Any, MoreViewHolder>(any.javaClass).getViewLayout()
    }

    override fun <T : Any, V : MoreViewHolder> register(viewType: MoreViewType<T, V>): MoreLink {
        linkManager.register(viewType)
        return this
    }

    override fun <T : Any, V : MoreViewHolder> attachViewType(clazz: Class<Any>): MoreViewType<T, V> = linkManager.attachViewType(clazz)
}