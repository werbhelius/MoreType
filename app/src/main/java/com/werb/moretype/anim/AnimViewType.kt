package com.werb.moretype.anim

import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlin.reflect.KClass
import kotlinx.android.synthetic.main.item_view_anim.view.*

/**
 * Created by wanbo on 2017/7/15.
 */
class AnimViewType : MoreViewType<AnimType>() {

    override fun getViewLayout(): Int = R.layout.item_view_anim

    override fun getViewModel(): KClass<AnimType> = AnimType::class

    override fun bindData(data: AnimType, holder: MoreViewHolder) {
        holder.itemView.title.text = data.title
        holder.itemView.type.text = data.type
        holder.itemView.icon.setImageURI(data.typeIcon)
        holder.itemView.thumb.setImageURI(data.thumb)
    }
}