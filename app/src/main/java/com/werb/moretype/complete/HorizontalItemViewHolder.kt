package com.werb.moretype.complete

import android.view.View
import com.werb.library.MoreViewHolder
import com.werb.moretype.single.SingleText
import kotlinx.android.synthetic.main.item_view_horizontal_item.*

/**
 * Created by wanbo on 2017/7/15.
 */
class HorizontalItemViewHolder(values: MutableMap<String, Any>, containerView: View) : MoreViewHolder<SingleText>(values, containerView) {

    override fun bindData(data: SingleText, payloads: List<Any>) {
        icon.setImageURI(data.url)
        title.text = data.title
        desc.text = data.desc
        addOnClickListener(close)
    }
}