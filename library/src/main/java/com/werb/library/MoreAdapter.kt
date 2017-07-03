package com.werb.library

import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup

/**
 * [MoreAdapter] build viewHolder with data
 * Created by wanbo on 2017/7/2.
 */
class MoreAdapter : Adapter<ViewHolder>() {

    var list: List<Any> = mutableListOf()
        private set

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }


}