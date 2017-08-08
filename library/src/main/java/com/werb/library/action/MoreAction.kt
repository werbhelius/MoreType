package com.werb.library.action

import android.view.View
import com.werb.library.MoreViewHolder


/**
 * [MoreAction] action of ViewHolder
 * Created by wanbo on 2017/7/2.
 */
abstract class MoreAction: Action{

    var moreListener: MoreClickListener? = null
    lateinit var itemView: View

    override fun initHolder(holder: MoreViewHolder) {
        this.itemView = holder.getItemView()
    }

    override fun bindHolder(holder: MoreViewHolder) {
        holder.setActionListener(this)
    }

    override fun setMoreClickListener(listener: MoreClickListener) {
        this.moreListener = listener
    }

}