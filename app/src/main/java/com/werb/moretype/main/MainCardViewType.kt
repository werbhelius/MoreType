package com.werb.moretype.main

import android.content.Intent
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.CardView
import android.view.View
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import com.werb.moretype.anim.AnimActivity
import com.werb.moretype.click.ItemClickActivity
import com.werb.moretype.complete.CompleteActivity
import com.werb.moretype.me.AboutMeActivity
import com.werb.moretype.multi.MultiRegisterActivity
import com.werb.moretype.single.SingleRegisterActivity
import kotlin.reflect.KClass
import kotlinx.android.synthetic.main.item_view_main.view.*

/**
 * Created by wanbo on 2017/7/14.
 */
class MainCardViewType : MoreViewType<MainCard>(R.layout.item_view_main) {

    private lateinit var card_title: AppCompatTextView
    private lateinit var card_desc: AppCompatTextView
    private lateinit var main_card_layout: CardView

    override fun initView(holder: MoreViewHolder) {
        card_title = holder.findViewOften<AppCompatTextView>(R.id.card_title)
        card_desc = holder.findViewOften<AppCompatTextView>(R.id.card_desc)
        main_card_layout = holder.findViewOften<CardView>(R.id.main_card_layout)
    }

    override fun bindData(data: MainCard, holder: MoreViewHolder) {
        card_title.text = data.cardTitle
        card_desc.text = data.cardDesc
        main_card_layout.setOnClickListener { itemClick(holder) }
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
            5 -> { intent.setClass(content, AboutMeActivity::class.java) }
            else -> {

            }
        }
        content.startActivity(intent)
    }
}