package com.werb.moretype.anim

import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlinx.android.synthetic.main.item_view_anim.*

/**
 * Created by wanbo on 2017/7/15.
 */
class AnimViewType : MoreViewType<AnimType>(R.layout.item_view_anim) {

    override fun bindData(data: AnimType, holder: MoreViewHolder) {
        holder.title.text = data.title
        holder.type.text = data.type
        holder.icon.setImageURI(data.typeIcon)
        holder.thumb.setImageURI(data.thumb)
    }
}