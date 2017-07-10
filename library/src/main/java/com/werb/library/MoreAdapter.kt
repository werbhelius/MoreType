package com.werb.library

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlin.reflect.KClass

/**
 * [MoreAdapter] build viewHolder with data
 * Created by wanbo on 2017/7/2.
 */
class MoreAdapter : Adapter<ViewHolder>(), MoreLink {

    private var list: MutableList<Any> = mutableListOf()

    private val linkManager: MoreLink = MoreLinkManager()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val moreViewType = buildViewType(viewType)
        val viewHolder = moreViewType.onCreateViewHolder(LayoutInflater.from(parent?.context), parent as ViewGroup)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val any = list[position]
        val attachViewType = attachViewType(any::class)
        attachViewType.buildHolder(holder as MoreViewHolder)
        attachViewType.bindData(any, holder)
    }

    fun loadData(data: Any) {
        if (data is List<*>) {
            for (d in data){
                d?.let {
                    list.add(it)
                    notifyItemChanged(list.indexOf(d))
                }
            }
        } else {
            list.add(data)
            notifyItemChanged(list.indexOf(data))
        }
    }

    fun attachTo(view: RecyclerView): MoreLink{
        view.adapter = this
        return this
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        val any = list[position]
        return attachViewType(any::class).getViewLayout()
    }

    override fun register(viewType: MoreViewType<*>): MoreLink {
        linkManager.register(viewType)
        return this
    }

    override fun attachViewType(clazz: KClass<out Any>): MoreViewType<Any> = linkManager.attachViewType(clazz)

    override fun buildViewType(type: Int): MoreViewType<Any> = linkManager.buildViewType(type)
}