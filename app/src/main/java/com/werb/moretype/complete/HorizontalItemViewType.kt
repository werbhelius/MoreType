package com.werb.moretype.complete

import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import com.werb.moretype.single.SingleText
import kotlinx.android.synthetic.main.item_view_horizontal_item.*

/**
 * Created by wanbo on 2017/7/15.
 */
class HorizontalItemViewType: MoreViewType<SingleText>(R.layout.item_view_horizontal_item) {

    override fun bindData(data: SingleText, holder: MoreViewHolder) {
        holder.icon.setImageURI(data.url)
        holder.title.text = data.title
        holder.desc.text = data.desc
        holder.addOnClickListener(holder.close)
    }
}