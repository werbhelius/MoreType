package com.werb.library.scroll

import android.support.v7.widget.RecyclerView

interface IViewHolderScrollMonitor{

    //viewholder attach detach
    fun onViewAttachedToWindow(){}
    fun onViewDetachedFromWindow(){}

    //home lockscreen
    fun onWindowFocusChanged(hasFocus: Boolean) {}

    fun onPauseResume(onResume: Boolean) {}

    //scroll
    fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {}
    fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {}
}