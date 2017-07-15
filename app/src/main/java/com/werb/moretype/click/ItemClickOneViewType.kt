package com.werb.moretype.click

import android.widget.Toast
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlin.reflect.KClass
import kotlinx.android.synthetic.main.item_view_click_one.view.*

/**
 * Created by wanbo on 2017/7/15.
 */
class ItemClickOneViewType: MoreViewType<ItemClick>() {

    override fun getViewLayout(): Int = R.layout.item_view_click_one

    override fun getViewModel(): KClass<ItemClick> = ItemClick::class

    override fun bindData(data: ItemClick, holder: MoreViewHolder) {
        val context = holder.itemView.context
        holder.itemView.title.text = data.title
        holder.itemView.icon.setImageURI(data.url)
        holder.itemView.setOnClickListener {
            Toast.makeText(context, " click in ViewType position is " + holder.layoutPosition.toString(), Toast.LENGTH_SHORT).show()
        }
        holder.itemView.icon.tag = data.url
        holder.addOnClickListener(holder.itemView.icon)
        holder.addOnClickListener(holder.itemView.button)
    }

}