package com.werb.moretype.me

import android.view.View
import com.werb.library.MoreViewHolder
import kotlinx.android.synthetic.main.item_view_about_me_message.*

/**
 * Created by wanbo on 2017/7/15.
 */
class MeMessageViewHolder(values: MutableMap<String, Any>, containerView: View) : MoreViewHolder<MeMessage>(values, containerView) {

    override fun bindData(data: MeMessage, payloads: List<Any>) {
        message.text = data.message
    }
}