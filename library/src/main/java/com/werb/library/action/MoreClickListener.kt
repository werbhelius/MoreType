package com.werb.library.action

import android.view.View

/**
 * Created by wanbo on 2017/7/2.
 */
abstract class MoreClickListener {

    open fun onItemClick(view: View, position: Int){}

    open fun onItemLongClick(view: View, position: Int): Boolean { return false }
}