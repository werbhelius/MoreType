package com.werb.moretype.single

import android.graphics.Rect
import android.view.View

/**
 * Created by wanbo on 2017/7/14.
 */
class SingleItemDecoration(val space: Int) : androidx.recyclerview.widget.RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: androidx.recyclerview.widget.RecyclerView, state: androidx.recyclerview.widget.RecyclerView.State) {
        parent?.let {
            val position = parent.getChildLayoutPosition(view)
            if (position != 0) {
                outRect?.right = space
                outRect?.left = space
            }
        }
    }

}