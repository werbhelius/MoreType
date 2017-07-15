package com.werb.moretype.me

import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlin.reflect.KClass
import kotlinx.android.synthetic.main.item_view_about_me_title.view.*

/**
 * Created by wanbo on 2017/7/15.
 */
class MeTitleViewType: MoreViewType<String>() {
    override fun getViewLayout(): Int = R.layout.item_view_about_me_title

    override fun getViewModel(): KClass<String> = String::class

    override fun bindData(data: String, holder: MoreViewHolder) {
        holder.itemView.title.text = data
    }
}