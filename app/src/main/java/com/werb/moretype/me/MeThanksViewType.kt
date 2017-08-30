package com.werb.moretype.me

import android.content.Intent
import android.net.Uri
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlinx.android.synthetic.main.item_view_about_me_thx.*

/**
 * Created by wanbo on 2017/7/15.
 */
class MeThanksViewType: MoreViewType<MeThanks>(R.layout.item_view_about_me_thx) {

    override fun bindData(data: MeThanks, holder: MoreViewHolder) {
        holder.name.text = data.name
        holder.desc.text = data.desc
        holder.icon.setImageURI(data.url)
        holder.itemView.setOnClickListener {
            val intent = Intent()
            intent.action = "android.intent.action.VIEW"
            intent.data = Uri.parse(data.gitHub)
            holder.itemView.context.startActivity(intent)
        }
    }
}