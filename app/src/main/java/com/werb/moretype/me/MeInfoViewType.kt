package com.werb.moretype.me

import android.content.Intent
import android.net.Uri
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlinx.android.synthetic.main.item_view_about_me_info.view.*
import kotlin.reflect.KClass


/**
 * Created by wanbo on 2017/7/15.
 */
class MeInfoViewType : MoreViewType<MeInfo>() {

    override fun getViewLayout(): Int = R.layout.item_view_about_me_info

    override fun getViewModel(): KClass<MeInfo> = MeInfo::class

    override fun bindData(data: MeInfo, holder: MoreViewHolder) {
        val context = holder.itemView.context
        holder.itemView.name.text = data.name
        holder.itemView.desc.text = data.desc
        holder.itemView.email.text = data.email
        holder.itemView.github.text = data.gitHub
        holder.itemView.weibo.text = data.weiBo
        holder.itemView.icon.setImageURI(data.icon)
        holder.itemView.email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            val tos = arrayOf(data.email)
            intent.putExtra(Intent.EXTRA_EMAIL, tos)
            intent.type = "message/rfc882"
            context.startActivity(Intent.createChooser(intent, "choose email client"))

        }
        holder.itemView.github.setOnClickListener {
            val intent = Intent()
            intent.action = "android.intent.action.VIEW"
            intent.data = Uri.parse(data.gitHub)
            context.startActivity(intent)
        }
        holder.itemView.weibo.setOnClickListener {
            val intent = Intent()
            intent.action = "android.intent.action.VIEW"
            intent.data = Uri.parse(data.weiBo)
            context.startActivity(intent)
        }
    }
}