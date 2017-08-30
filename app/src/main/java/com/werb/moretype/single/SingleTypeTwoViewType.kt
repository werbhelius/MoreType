package com.werb.moretype.single

import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlinx.android.synthetic.main.item_view_single_type_two.*

/**
 * Created by wanbo on 2017/7/14.
 */
class SingleTypeTwoViewType: MoreViewType<SingleImage>(R.layout.item_view_single_type_two) {

    override fun bindData(data: SingleImage, holder: MoreViewHolder) {
        holder.title.text = data.title
        holder.icon.setImageURI(data.url)
    }
}