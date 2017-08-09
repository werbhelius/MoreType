package com.werb.moretype.single

import android.support.v7.widget.AppCompatTextView
import android.view.View
import com.facebook.drawee.view.SimpleDraweeView
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlinx.android.synthetic.main.item_view_single_type_two.view.*

/**
 * Created by wanbo on 2017/7/14.
 */
class SingleTypeTwoViewType: MoreViewType<SingleImage>(R.layout.item_view_single_type_two, SingleImage::class) {

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