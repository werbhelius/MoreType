package com.werb.moretype

import android.support.v7.widget.AppCompatTextView
import android.view.View
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.main.MainCard
import kotlinx.android.synthetic.main.item_view_title.view.*

/**
 * Created by wanbo on 2017/7/14.
 */
class TitleViewType: MoreViewType<MainCard>(R.layout.item_view_title) {

    private lateinit var title: AppCompatTextView
    private lateinit var desc: AppCompatTextView

    override fun initView(holder: MoreViewHolder) {
        title = holder.findViewOften(R.id.title)
        desc = holder.findViewOften(R.id.desc)
    }

    override fun bindData(data: MainCard, holder: MoreViewHolder) {
        title.text = data.cardTitle
        desc.desc.text = data.cardDesc
    }
}