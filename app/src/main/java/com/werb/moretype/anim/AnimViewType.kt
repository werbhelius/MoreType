package com.werb.moretype.anim

import android.support.v7.widget.AppCompatTextView
import android.view.View
import com.facebook.drawee.view.SimpleDraweeView
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlinx.android.synthetic.main.item_view_anim.view.*

/**
 * Created by wanbo on 2017/7/15.
 */
class AnimViewType : MoreViewType<AnimType>(R.layout.item_view_anim, AnimType::class) {

    private lateinit var title: AppCompatTextView
    private lateinit var type: AppCompatTextView
    private lateinit var icon: SimpleDraweeView
    private lateinit var thumb: SimpleDraweeView

    override fun initView(holder: MoreViewHolder) {
        title = holder.findViewOften(R.id.title)
        type = holder.findViewOften(R.id.type)
        icon = holder.findViewOften(R.id.icon)
        thumb = holder.findViewOften(R.id.thumb)
    }

    override fun bindData(data: AnimType, holder: MoreViewHolder) {
        title.text = data.title
        type.text = data.type
        icon.setImageURI(data.typeIcon)
        thumb.setImageURI(data.thumb)
    }
}