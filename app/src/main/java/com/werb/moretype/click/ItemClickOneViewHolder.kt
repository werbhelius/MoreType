package com.werb.moretype.click

import android.view.View
import android.widget.Toast
import com.werb.library.MoreViewHolder
import kotlinx.android.synthetic.main.item_view_click_one.*

/**
 * Created by wanbo on 2017/7/15.
 */
class ItemClickOneViewHolder(containerView: View) : MoreViewHolder<ItemClick>(containerView) {

    override fun bindData(data: ItemClick) {
        title.text = data.title
        icon.setImageURI(data.url)
        /* click in viewType */
        itemView.setOnClickListener {
            Toast.makeText(containerView.context, " click in ViewType position is " + layoutPosition.toString(), Toast.LENGTH_SHORT).show()
        }
        icon.tag = data.url
        /* click in activity */
        addOnClickListener(icon)
        addOnClickListener(button)
    }

}