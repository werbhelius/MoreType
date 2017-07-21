package com.werb.moretype.single

import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlinx.android.synthetic.main.item_view_single_type_one.view.*
import kotlin.reflect.KClass

/**
 * Created by wanbo on 2017/7/14.
 */
class SingleTypeOneViewType: MoreViewType<SingleText>() {

    override fun getViewLayout(): Int = R.layout.item_view_single_type_one

    override fun getViewModel(): KClass<SingleText> = SingleText::class

    override fun bindData(data: SingleText, holder: MoreViewHolder) {
        holder.itemView.title.text = data.title
        holder.itemView.desc.text = data.desc
        holder.itemView.icon.setImageURI(data.url)
    }
}