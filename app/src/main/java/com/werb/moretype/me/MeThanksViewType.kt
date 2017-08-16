package com.werb.moretype.me

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.AppCompatTextView
import android.view.View
import com.facebook.drawee.view.SimpleDraweeView
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlin.reflect.KClass
import kotlinx.android.synthetic.main.item_view_about_me_thx.view.*

/**
 * Created by wanbo on 2017/7/15.
 */
class MeThanksViewType: MoreViewType<MeThanks>(R.layout.item_view_about_me_thx) {

    private lateinit var name: AppCompatTextView
    private lateinit var desc: AppCompatTextView
    private lateinit var icon: SimpleDraweeView
    private lateinit var itemView: View

    override fun initView(holder: MoreViewHolder) {
        name = holder.findViewOften(R.id.name)
        desc = holder.findViewOften(R.id.desc)
        icon = holder.findViewOften(R.id.icon)
        this.itemView = holder.getItemView()
    }

    override fun bindData(data: MeThanks, holder: MoreViewHolder) {
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