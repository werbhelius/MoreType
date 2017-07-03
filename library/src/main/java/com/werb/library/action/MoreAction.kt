package com.werb.library.action

import android.view.View
import com.werb.library.MoreViewHolder


/**
 * [MoreAction] action of ViewHolder
 * Created by wanbo on 2017/7/2.
 */
abstract class MoreAction: Action{

    var holder: MoreViewHolder? = null
    var moreListener: MoreClickListener? = null

    override fun setMoreClickListener(listener: MoreClickListener?) {
        this.moreListener = listener
    }

    override fun buildHolder(holder: MoreViewHolder) {
        this.holder = holder
        holder.setActionListener(this)
    }

    override fun getChildView(viewId: Int): View?  = holder?.getChildView(viewId)

}