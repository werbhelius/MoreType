package com.werb.moretype.me

import android.content.Intent
import android.net.Uri
import android.view.View
import com.werb.library.MoreViewHolder
import kotlinx.android.synthetic.main.item_view_about_me_info.*


/**
 * Created by wanbo on 2017/7/15.
 */
class MeInfoViewHolder(values: MutableMap<String, Any>, containerView: View) : MoreViewHolder<MeInfo>(values, containerView) {

    override fun bindData(data: MeInfo, payloads: List<Any>) {
        val context = containerView.context
        name.text = data.name
        desc.text = data.desc
        email.text = data.email
        github.text = data.gitHub
        weibo.text = data.weiBo
        icon.setImageURI(data.icon)
        email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            val tos = arrayOf(data.email)
            intent.putExtra(Intent.EXTRA_EMAIL, tos)
            intent.type = "message/rfc882"
            context.startActivity(Intent.createChooser(intent, "choose email client"))

        }
        github.setOnClickListener {
            val intent = Intent()
            intent.action = "android.intent.action.VIEW"
            intent.data = Uri.parse(data.gitHub)
            context.startActivity(intent)
        }
        weibo.setOnClickListener {
            val intent = Intent()
            intent.action = "android.intent.action.VIEW"
            intent.data = Uri.parse(data.weiBo)
            context.startActivity(intent)
        }
    }
}