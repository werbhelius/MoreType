package com.werb.moretype.single

import android.graphics.Rect
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup

/**
 * Created by wanbo on 2017/7/14.
 */
class SingleItemDecoration(val space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        parent?.let {
            val position = parent.getChildLayoutPosition(view)
            if (position != 0) {
                outRect?.right = space
                outRect?.left = space
            }
        }
    }

}