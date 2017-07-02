package com.werb.library.action

import android.view.View

/**
 * Created by wanbo on 2017/7/2.
 */
interface MoreClickListener {

    fun onItemClick(view: View, position: Int)

    fun onItemLongClick(view: View, position: Int)
}