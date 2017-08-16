package com.werb.moretype.single

import android.support.v7.widget.AppCompatTextView
import com.facebook.drawee.view.SimpleDraweeView
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R

/**
 * Created by wanbo on 2017/7/14.
 */
class SingleTypeTwoViewType: MoreViewType<SingleImage>(R.layout.item_view_single_type_two) {

    private lateinit var title: AppCompatTextView
    private lateinit var icon: SimpleDraweeView

    override fun initView(holder: MoreViewHolder) {
        title = holder.findViewOften(R.id.title)
        icon = holder.findViewOften(R.id.icon)
    }

    override fun bindData(data: SingleImage, holder: MoreViewHolder) {
        title.text = data.title
        icon.setImageURI(data.url)
    }
}