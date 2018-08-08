package com.werb.library.scroll

import android.support.v7.widget.RecyclerView
import com.werb.library.MoreAdapter


internal interface IAdapterScrollMonitor{
    /**
     *adapter是否需要开启滑动监测
     */
    fun scrollMonitor(monitor: Boolean): MoreAdapter

    fun onWindowFocusChanged(hasFocus: Boolean)

    fun onPauseResume(onResume: Boolean)

    fun onHolderScrolled(recyclerView: RecyclerView, dx: Int, dy: Int)

    fun onHolderScrollStateChanged(recyclerView: RecyclerView, newState: Int)
}