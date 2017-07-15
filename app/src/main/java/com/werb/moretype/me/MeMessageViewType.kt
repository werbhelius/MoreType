package com.werb.moretype.me

import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlin.reflect.KClass
import kotlinx.android.synthetic.main.item_view_about_me_message.view.*

/**
 * Created by wanbo on 2017/7/15.
 */
class MeMessageViewType: MoreViewType<MeMessage>() {

    override fun getViewLayout(): Int = R.layout.item_view_about_me_message

    override fun getViewModel(): KClass<MeMessage> = MeMessage::class

    override fun bindData(data: MeMessage, holder: MoreViewHolder) {
        holder.itemView.message.text = data.message
    }
}