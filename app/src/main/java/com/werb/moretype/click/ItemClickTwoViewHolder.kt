package com.werb.moretype.click

import android.view.View
import android.widget.Toast
import com.werb.library.MoreViewHolder
import kotlinx.android.synthetic.main.item_view_click_two.*

/**
 * Created by wanbo on 2017/7/15.
 */
class ItemClickTwoViewHolder(containerView: View) : MoreViewHolder<ItemClick>(containerView) {

    override fun bindData(data: ItemClick, payloads: List<Any>) {
        title.text = data.title
        icon.setImageURI(data.url)
        itemView.setOnClickListener {
            Toast.makeText(containerView.context, " click in ViewType position is " + layoutPosition.toString(), Toast.LENGTH_SHORT).show()
        }
        icon.tag = data.url
        addOnClickListener(icon)
        addOnLongClickListener(button)
    }

}