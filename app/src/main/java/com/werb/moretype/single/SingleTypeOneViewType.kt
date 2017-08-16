package com.werb.moretype.single

import android.support.v7.widget.AppCompatTextView
import com.facebook.drawee.view.SimpleDraweeView
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R

/**
 * Created by wanbo on 2017/7/14.
 */
class SingleTypeOneViewType: MoreViewType<SingleText>(R.layout.item_view_single_type_one) {

    private lateinit var title: AppCompatTextView
    private lateinit var desc: AppCompatTextView
    private lateinit var icon: SimpleDraweeView

    override fun initView(holder: MoreViewHolder) {
        title = holder.findViewOften(R.id.title)
        desc = holder.findViewOften(R.id.desc)
        icon = holder.findViewOften(R.id.icon)
    }

    override fun bindData(data: SingleText, holder: MoreViewHolder) {
        title.text = data.title
        desc.text = data.desc
        icon.setImageURI(data.url)
    }


}