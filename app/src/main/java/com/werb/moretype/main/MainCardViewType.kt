package com.werb.moretype.main

import android.content.Intent
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import com.werb.moretype.anim.AnimActivity
import com.werb.moretype.click.ItemClickActivity
import com.werb.moretype.complete.CompleteActivity
import com.werb.moretype.multi.MultiRegisterActivity
import com.werb.moretype.single.SingleRegisterActivity
import kotlin.reflect.KClass
import kotlinx.android.synthetic.main.item_view_main.view.*

/**
 * Created by wanbo on 2017/7/14.
 */
class MainCardViewType : MoreViewType<MainCard>() {

    override fun getViewLayout(): Int = R.layout.item_view_main

    override fun getViewModel(): KClass<MainCard> = MainCard::class

    override fun bindData(data: MainCard, holder: MoreViewHolder) {
        holder.itemView.card_title.text = data.cardTitle
        holder.itemView.card_desc.text = data.cardDesc
        holder.itemView.main_card_layout.setOnClickListener { itemClick(holder) }
    }

    fun itemClick(holder: MoreViewHolder) {
        val content = holder.itemView.context
        val intent = Intent()
        when (holder.layoutPosition) {
            0 -> { intent.setClass(content, SingleRegisterActivity::class.java) }
            1 -> { intent.setClass(content, MultiRegisterActivity::class.java) }
            2 -> { intent.setClass(content, AnimActivity::class.java) }
            3 -> { intent.setClass(content, ItemClickActivity::class.java) }
            4 -> { intent.setClass(content, CompleteActivity::class.java) }
            5 -> {
            }
            else -> {

            }
        }
        content.startActivity(intent)
    }
}