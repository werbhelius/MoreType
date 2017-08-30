package com.werb.moretype.me

import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlinx.android.synthetic.main.item_view_about_me_title.*

/**
 * Created by wanbo on 2017/7/15.
 */
class MeTitleViewType: MoreViewType<String>(R.layout.item_view_about_me_title) {

    override fun bindData(data: String, holder: MoreViewHolder) {
        holder.title.text = data
    }
}