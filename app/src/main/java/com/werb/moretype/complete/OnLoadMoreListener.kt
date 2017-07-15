package com.werb.moretype.complete

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View


/**
 * Created by wanbo on 2017/7/15.
 */

abstract class OnLoadMoreListener : RecyclerView.OnScrollListener() {

    private var itemCount: Int = 0
    private var lastItemCount: Int = 0
    var isShowFooter: Boolean = false

    abstract fun isHasMore(): Boolean

    abstract fun onLoadMore(v: View)

    abstract fun showFooter(v: View)

    fun doOnScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

    }

    fun doOnScrollStateChanged() {

    }

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
            doOnScrollStateChanged()
        }
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

        doOnScrolled(recyclerView, dx, dy)

        if (dy <= 0) {
            return
        }
        val layoutManager: LinearLayoutManager
        if (recyclerView.layoutManager is LinearLayoutManager) {
            layoutManager = recyclerView.layoutManager as LinearLayoutManager
            itemCount = layoutManager.itemCount
        } else {
            Log.e("OnLoadMoreListener", "The OnLoadMoreListener only support LinearLayoutManager")
            return
        }

        val lastVisibleItem = layoutManager.findLastVisibleItemPosition()
        itemCount = layoutManager.itemCount
        if (lastItemCount != itemCount && lastVisibleItem + 1 == itemCount && !isShowFooter) {
            if (isHasMore()) {
                showFooter(recyclerView)
                onLoadMore(recyclerView)
            } else {
                lastItemCount = itemCount
            }
        }
    }
}