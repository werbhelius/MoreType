package com.werb.moretype.me

import android.view.View
import com.werb.library.MoreViewHolder
import kotlinx.android.synthetic.main.item_view_about_me_title.*

/**
 * Created by wanbo on 2017/7/15.
 */
class MeTitleViewType(values: MutableMap<String, Any>, containerView: View) : MoreViewHolder<String>(values, containerView) {

    override fun bindData(data: String, payloads: List<Any>) {
        title.text = data
    }
}