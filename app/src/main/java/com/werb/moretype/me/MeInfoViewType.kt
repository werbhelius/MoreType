package com.werb.moretype.me

import android.content.Intent
import android.net.Uri
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlinx.android.synthetic.main.item_view_about_me_info.*


/**
 * Created by wanbo on 2017/7/15.
 */
class MeInfoViewType : MoreViewType<MeInfo>(R.layout.item_view_about_me_info) {

    override fun bindData(data: MeInfo, holder: MoreViewHolder) {
        val context = holder.itemView.context
        holder.name.text = data.name
        holder.desc.text = data.desc
        holder.email.text = data.email
        holder.github.text = data.gitHub
        holder.weibo.text = data.weiBo
        holder.icon.setImageURI(data.icon)
        holder.email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            val tos = arrayOf(data.email)
            intent.putExtra(Intent.EXTRA_EMAIL, tos)
            intent.type = "message/rfc882"
            context.startActivity(Intent.createChooser(intent, "choose email client"))

        }
        holder.github.setOnClickListener {
            val intent = Intent()
            intent.action = "android.intent.action.VIEW"
            intent.data = Uri.parse(data.gitHub)
            context.startActivity(intent)
        }
        holder.weibo.setOnClickListener {
            val intent = Intent()
            intent.action = "android.intent.action.VIEW"
            intent.data = Uri.parse(data.weiBo)
            context.startActivity(intent)
        }
    }
}