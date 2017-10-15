package com.werb.moretype.me

import android.content.Intent
import android.net.Uri
import android.view.View
import com.werb.library.MoreViewHolder
import kotlinx.android.synthetic.main.item_view_about_me_thx.*

/**
 * Created by wanbo on 2017/7/15.
 */
class MeThanksViewHolder(containerView: View) : MoreViewHolder<MeThanks>(containerView) {

    override fun bindData(data: MeThanks, payloads: List<Any>) {
        name.text = data.name
        desc.text = data.desc
        icon.setImageURI(data.url)
        itemView.setOnClickListener {
            val intent = Intent()
            intent.action = "android.intent.action.VIEW"
            intent.data = Uri.parse(data.gitHub)
            itemView.context.startActivity(intent)
        }
    }
}