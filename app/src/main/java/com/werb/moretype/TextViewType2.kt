package com.werb.moretype

import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import kotlinx.android.synthetic.main.item_view_string.view.*
import kotlin.reflect.KClass

/**
 * Created by wanbo on 2017/7/8.
 */
class TextViewType2: MoreViewType<String>() {

    override fun getViewLayout(): Int = R.layout.item_view_string2

    override fun getViewModel(): KClass<String> {
        return String::class
    }

    override fun bindData(t: String, holder: MoreViewHolder?) {
        holder?.let {
            it.itemView.text.text = t
            it.addOnClickListener(it.itemView.text)
        }
    }

}