package com.werb.moretype.click

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.view.View
import android.widget.Toast
import com.facebook.drawee.view.SimpleDraweeView
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlin.reflect.KClass
import kotlinx.android.synthetic.main.item_view_click_two.view.*

/**
 * Created by wanbo on 2017/7/15.
 */
class ItemClickTwoViewType: MoreViewType<ItemClick>(R.layout.item_view_click_two, ItemClick::class) {

    private lateinit var itemView: View
    private lateinit var context: Context
    private lateinit var title: AppCompatTextView
    private lateinit var icon: SimpleDraweeView

    override fun initView(holder: MoreViewHolder) {
        this.itemView = holder.getItemView()
        context = holder.getItemView().context
        title = holder.findViewOften(R.id.title)
        icon = holder.findViewOften(R.id.icon)
    }

    override fun bindData(data: ItemClick, holder: MoreViewHolder) {
        title.text = data.title
        icon.setImageURI(data.url)
        itemView.setOnClickListener {
            Toast.makeText(context, " click in ViewType position is " + holder.layoutPosition.toString(), Toast.LENGTH_SHORT).show()
        }
        holder.itemView.icon.tag = data.url
        holder.addOnClickListener(holder.itemView.icon)
        holder.addOnLongClickListener(holder.itemView.button)
    }

}