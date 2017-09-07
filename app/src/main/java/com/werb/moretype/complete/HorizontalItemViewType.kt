package com.werb.moretype.complete

import android.support.v7.widget.AppCompatTextView
import android.widget.ImageView
import com.facebook.drawee.view.SimpleDraweeView
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import com.werb.moretype.single.SingleText
import kotlinx.android.synthetic.main.item_view_horizontal_item.*

/**
 * Created by wanbo on 2017/7/15.
 */
class HorizontalItemViewType: MoreViewType<SingleText>(R.layout.item_view_horizontal_item) {

    private lateinit var title: AppCompatTextView
    private lateinit var desc: AppCompatTextView
    private lateinit var icon: SimpleDraweeView
    private lateinit var close: ImageView

    override fun initView(holder: MoreViewHolder) {
        title = holder.findViewOften(R.id.title)
        desc = holder.findViewOften(R.id.desc)
        icon = holder.findViewOften(R.id.icon)
        close = holder.findViewOften(R.id.close)
    }

    override fun bindData(data: SingleText, holder: MoreViewHolder) {
        icon.setImageURI(data.url)
        title.text = data.title
        desc.text = data.desc
        holder.addOnClickListener(close)
    }
}