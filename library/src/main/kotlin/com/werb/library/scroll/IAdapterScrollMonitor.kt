package com.werb.library.scroll

import android.support.v7.widget.RecyclerView
import com.werb.library.MoreAdapter


internal interface IAdapterScrollMonitor{
    /**
     * adapter滑动监测
     * @param monitor 是否开启监控，默认false不开启
     * @param direction 是否按滑动方向分发事件默认为true，向上滑动时自上而下分发，向下时自下而上分发
     */
    fun scrollMonitor(monitor: Boolean = false, direction: Boolean = true): MoreAdapter

    fun onWindowFocusChanged(hasFocus: Boolean)

    fun onPauseResume(onResume: Boolean)

    fun onHolderScrolled(recyclerView: RecyclerView, dx: Int, dy: Int)

    fun onHolderScrollStateChanged(recyclerView: RecyclerView, newState: Int)
}