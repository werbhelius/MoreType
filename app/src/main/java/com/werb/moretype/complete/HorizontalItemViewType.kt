package com.werb.moretype.complete

import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import com.werb.moretype.single.SingleText
import kotlin.reflect.KClass
import kotlinx.android.synthetic.main.item_view_horizontal_item.view.*

/**
 * Created by wanbo on 2017/7/15.
 */
class HorizontalItemViewType: MoreViewType<SingleText>() {

    override fun getViewLayout(): Int = R.layout.item_view_horizontal_item

    override fun getViewModel(): KClass<SingleText> = SingleText::class

    override fun bindData(data: SingleText, holder: MoreViewHolder) {
        holder.itemView.icon.setImageURI(data.url)
        holder.itemView.title.text = data.title
        holder.itemView.desc.text = data.desc
        holder.addOnClickListener(holder.itemView.close)
    }
}