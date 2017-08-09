package com.werb.moretype.me

import android.support.v7.widget.AppCompatTextView
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R

/**
 * Created by wanbo on 2017/7/15.
 */
class MeMessageViewType: MoreViewType<MeMessage>(R.layout.item_view_about_me_message, MeMessage::class) {

    private lateinit var message: AppCompatTextView

    override fun initView(holder: MoreViewHolder) {
        message = holder.findViewOften(R.id.message)
    }

    override fun bindData(data: MeMessage, holder: MoreViewHolder) {
        message.text = data.message
    }
}