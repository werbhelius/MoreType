package com.werb.library.action

import android.view.View
import com.werb.library.MoreViewHolder


/**
 * [MoreAction] action of ViewHolder
 * Created by wanbo on 2017/7/2.
 */
abstract class MoreAction {

    var listener: MoreClickListener? = null

    fun setMoreClickListener(listener: MoreClickListener?){
        this.listener = listener
    }

    open fun getChildView(viewId: Int) : View? = null

}