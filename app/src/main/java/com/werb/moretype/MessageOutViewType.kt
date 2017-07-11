package com.werb.moretype

import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import kotlin.reflect.KClass
import kotlinx.android.synthetic.main.item_view_message_in.view.*

/**
 * Created by wanbo on 2017/7/10.
 */
class MessageOutViewType : MoreViewType<People>() {

    override fun getViewLayout(): Int = R.layout.item_view_message_out

    override fun getViewModel(): KClass<People> = People::class

    override fun bindData(t: People, holder: MoreViewHolder?) {
        holder?.let {
            it.itemView.name.text = t.name
            it.itemView.age.text = t.age.toString()
        }
    }
}