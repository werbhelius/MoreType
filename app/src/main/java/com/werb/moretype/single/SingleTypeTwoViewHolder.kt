package com.werb.moretype.single

import android.view.View
import com.werb.library.MoreViewHolder
import com.werb.library.annotation.LayoutID
import com.werb.moretype.R
import kotlinx.android.synthetic.main.item_view_single_type_two.*

/**
 * Created by wanbo on 2017/7/14.
 */

@LayoutID(R.layout.item_view_single_type_two)
class SingleTypeTwoViewHolder(containerView: View) : MoreViewHolder<SingleImage>(containerView) {

    override fun bindData(data: SingleImage, payloads: List<Any>) {
        title.text = data.title
        icon.setImageURI(data.url)
    }
}