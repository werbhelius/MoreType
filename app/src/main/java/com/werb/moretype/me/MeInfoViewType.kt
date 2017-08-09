package com.werb.moretype.me

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.AppCompatTextView
import android.view.View
import com.facebook.drawee.view.SimpleDraweeView
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlinx.android.synthetic.main.item_view_about_me_info.view.*
import kotlin.reflect.KClass


/**
 * Created by wanbo on 2017/7/15.
 */
class MeInfoViewType : MoreViewType<MeInfo>(R.layout.item_view_about_me_info, MeInfo::class) {

    private lateinit var name: AppCompatTextView
    private lateinit var desc: AppCompatTextView
    private lateinit var email: AppCompatTextView
    private lateinit var github: AppCompatTextView
    private lateinit var weibo: AppCompatTextView
    private lateinit var icon: SimpleDraweeView
    private lateinit var itemView: View

    override fun initView(holder: MoreViewHolder) {
        name = holder.findViewOften(R.id.name)
        desc = holder.findViewOften(R.id.desc)
        email = holder.findViewOften(R.id.email)
        github = holder.findViewOften(R.id.github)
        weibo = holder.findViewOften(R.id.weibo)
        icon =holder.findViewOften(R.id.icon)
        this.itemView = holder.getItemView()
    }

    override fun bindData(data: MeInfo, holder: MoreViewHolder) {
        val context = holder.itemView.context
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