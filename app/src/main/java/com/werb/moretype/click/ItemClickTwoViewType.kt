package com.werb.moretype.click

import android.widget.Toast
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlinx.android.synthetic.main.item_view_click_two.*

/**
 * Created by wanbo on 2017/7/15.
 */
class ItemClickTwoViewType: MoreViewType<ItemClick>(R.layout.item_view_click_two) {

    override fun bindData(data: ItemClick, holder: MoreViewHolder) {
        holder.title.text = data.title
        holder.icon.setImageURI(data.url)
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, " click in ViewType position is " + holder.layoutPosition.toString(), Toast.LENGTH_SHORT).show()
        }
        holder.icon.tag = data.url
        holder.addOnClickListener(holder.icon)
        holder.addOnLongClickListener(holder.button)
    }

}