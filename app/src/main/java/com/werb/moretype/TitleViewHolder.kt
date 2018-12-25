package com.werb.moretype

import android.view.View
import com.werb.library.MoreViewHolder
import com.werb.library.link.LayoutID
import com.werb.moretype.main.MainCard
import kotlinx.android.synthetic.main.item_view_title.view.*

/**
 * Created by wanbo on 2017/7/14.
 */

@LayoutID(R.layout.item_view_title)
class TitleViewHolder(values: MutableMap<String, Any>, containerView: View) : MoreViewHolder<MainCard>(values, containerView) {

    private val title = containerView.title
    private val desc = containerView.desc

    override fun bindData(data: MainCard, payloads: List<Any>) {
        title.text = data.cardTitle
        desc.text = data.cardDesc
    }


}