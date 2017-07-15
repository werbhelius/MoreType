package com.werb.library.action

import android.view.View
import com.werb.library.MoreViewHolder

/**
 * [Action] Define Action we need
 * Created by wanbo on 2017/7/3.
 */
interface Action {

    fun buildHolder(holder: MoreViewHolder)

    fun setMoreClickListener(listener: MoreClickListener)

}