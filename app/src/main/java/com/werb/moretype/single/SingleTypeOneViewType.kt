package com.werb.moretype.single

import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlinx.android.synthetic.main.item_view_single_type_one.*

/**
 * Created by wanbo on 2017/7/14.
 */
class SingleTypeOneViewType: MoreViewType<SingleText>(R.layout.item_view_single_type_one) {

    override fun bindData(data: SingleText, holder: MoreViewHolder) {
        holder.title.text = data.title
        holder.desc.text = data.desc
        holder.icon.setImageURI(data.url)
    }


}