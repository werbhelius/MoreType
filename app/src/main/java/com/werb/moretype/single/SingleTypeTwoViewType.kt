package com.werb.moretype.single

import android.widget.Toast
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlin.reflect.KClass
import kotlinx.android.synthetic.main.item_view_single_type_two.view.*

/**
 * Created by wanbo on 2017/7/14.
 */
class SingleTypeTwoViewType: MoreViewType<SingleImage>() {

    override fun getViewLayout(): Int = R.layout.item_view_single_type_two

    override fun getViewModel(): KClass<SingleImage> = SingleImage::class

    override fun bindData(data: SingleImage, holder: MoreViewHolder) {
        holder.itemView.title.text = data.title
        holder.itemView.icon.setImageURI(data.url)
    }
}