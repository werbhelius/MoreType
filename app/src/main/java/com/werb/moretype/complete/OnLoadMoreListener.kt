package com.werb.moretype.complete

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView


/**
 * Created by wanbo on 2017/7/15.
 */

abstract class OnLoadMoreListener : androidx.recyclerview.widget.RecyclerView.OnScrollListener() {

    private var itemCount: Int = 0
    private var lastItemCount: Int = 0
    var isShowFooter: Boolean = false

    abstract fun isHasMore(): Boolean

    abstract fun onLoadMore(v: View)

    abstract fun showFooter(v: View)

    fun doOnScrolled(recyclerView: androidx.recyclerview.widget.RecyclerView, dx: Int, dy: Int) {

    }

    fun doOnScrollStateChanged() {

    }

    override fun onScrollStateChanged(recyclerView: androidx.recyclerview.widget.RecyclerView, newState: Int) {
        if (newState == androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_DRAGGING) {
            doOnScrollStateChanged()
        }
    }

    override fun onScrolled(recyclerView: androidx.recyclerview.widget.RecyclerView, dx: Int, dy: Int) {

        doOnScrolled(recyclerView, dx, dy)

        if (dy <= 0) {
            return
        }
        val layoutManager: androidx.recyclerview.widget.LinearLayoutManager
        if (recyclerView.layoutManager is androidx.recyclerview.widget.LinearLayoutManager) {
            layoutManager = recyclerView.layoutManager as androidx.recyclerview.widget.LinearLayoutManager
            itemCount = layoutManager.itemCount
        } else {
            Log.e("OnLoadMoreListener", "The OnLoadMoreListener only support LinearLayoutManager")
            return
        }

        val lastVisibleItem = layoutManager.findLastVisibleItemPosition()
        itemCount = layoutManager.itemCount
        if (lastItemCount != itemCount && lastVisibleItem + 1 == itemCount && !isShowFooter) {
            if (isHasMore()) {
                recyclerView.post {
                    showFooter(recyclerView)
                    onLoadMore(recyclerView)
                }
            } else {
                lastItemCount = itemCount
            }
        }
    }
}