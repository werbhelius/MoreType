package com.werb.library.action

import com.werb.library.MoreViewHolder


/**
 * [MoreAction] action of ViewHolder
 * Created by wanbo on 2017/7/2.
 */
abstract class MoreAction: Action{

    var moreListener: MoreClickListener? = null

    override fun buildHolder(holder: MoreViewHolder) {
        holder.setActionListener(this)
    }

    override fun setMoreClickListener(listener: MoreClickListener?) {
        this.moreListener = listener
    }

}