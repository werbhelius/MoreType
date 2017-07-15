package com.werb.moretype.me

import android.content.Intent
import android.net.Uri
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlin.reflect.KClass
import kotlinx.android.synthetic.main.item_view_about_me_thx.view.*

/**
 * Created by wanbo on 2017/7/15.
 */
class MeThanksViewType: MoreViewType<MeThanks>() {

    override fun getViewLayout(): Int = R.layout.item_view_about_me_thx

    override fun getViewModel(): KClass<MeThanks> = MeThanks::class

    override fun bindData(data: MeThanks, holder: MoreViewHolder) {
        holder.itemView.name.text = data.name
        holder.itemView.desc.text = data.desc
        holder.itemView.icon.setImageURI(data.url)
        holder.itemView.setOnClickListener {
            val intent = Intent()
            intent.action = "android.intent.action.VIEW"
            intent.data = Uri.parse(data.gitHub)
            holder.itemView.context.startActivity(intent)
        }
    }
}