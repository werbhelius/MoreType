package com.werb.moretype.me

import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlinx.android.synthetic.main.item_view_about_me_message.*

/**
 * Created by wanbo on 2017/7/15.
 */
class MeMessageViewType: MoreViewType<MeMessage>(R.layout.item_view_about_me_message) {

    override fun bindData(data: MeMessage, holder: MoreViewHolder) {
        holder.message.text = data.message
    }
}