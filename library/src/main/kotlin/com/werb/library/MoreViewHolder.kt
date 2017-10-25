package com.werb.library

import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import com.werb.library.action.MoreClickListener
import kotlinx.android.extensions.LayoutContainer


/**
 * [MoreViewHolder] Base ViewHolder implement Action fun
 * Created by wanbo on 2017/7/2.
 */
abstract class MoreViewHolder<T : Any>(override val containerView: View) : ViewHolder(containerView), LayoutContainer {

    internal var clickListener: MoreClickListener? = null

    fun getItemView() = itemView

    fun addOnClickListener(viewId: Int) {
        itemView.findViewById<View>(viewId).setOnClickListener { clickListener?.onItemClick(it, layoutPosition) }
    }

    fun addOnClickListener(view: View) {
        view.setOnClickListener { clickListener?.onItemClick(it, layoutPosition) }
    }

    fun addOnLongClickListener(viewId: Int) {
        clickListener?.let {
            val _this = it
            itemView.findViewById<View>(viewId).setOnLongClickListener {
                _this.onItemLongClick(it, layoutPosition)
            }
        }
    }

    fun addOnLongClickListener(view: View) {
        clickListener?.let {
            val _this = it
            view.setOnLongClickListener {
                _this.onItemLongClick(view, layoutPosition)
            }
        }
    }

    /** [bindData] bind data with T  */
    abstract fun bindData(data: T, payloads: List<Any> = arrayListOf())

    /** [unBindData] unbind and release resources*/
    open fun unBindData() {}

}