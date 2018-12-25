package com.werb.moretype.single

import android.view.View
import com.werb.library.MoreViewHolder
import com.werb.library.link.LayoutID
import com.werb.moretype.R
import kotlinx.android.synthetic.main.item_view_single_type_one.*

/**
 * Created by wanbo on 2017/7/14.
 */

@LayoutID(R.layout.item_view_single_type_one)
class SingleTypeOneViewHolder(values: MutableMap<String, Any>, containerView: View) : MoreViewHolder<SingleText>(values, containerView) {

    override fun bindData(data: SingleText, payloads: List<Any>) {
        title.text = data.title
        desc.text = data.desc
        icon.setImageURI(data.url)
    }

}