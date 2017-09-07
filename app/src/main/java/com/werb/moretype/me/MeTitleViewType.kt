package com.werb.moretype.me

import android.support.v7.widget.AppCompatTextView
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlinx.android.synthetic.main.item_view_about_me_title.*

/**
 * Created by wanbo on 2017/7/15.
 */
class MeTitleViewType: MoreViewType<String>(R.layout.item_view_about_me_title) {

    private lateinit var title: AppCompatTextView

    override fun initView(holder: MoreViewHolder) {
        title = holder.findViewOften(R.id.title)
    }

    override fun bindData(data: String, holder: MoreViewHolder) {
        title.text = data
    }
}