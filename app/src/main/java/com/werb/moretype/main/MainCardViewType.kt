package com.werb.moretype.main

import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlin.reflect.KClass
import kotlinx.android.synthetic.main.item_view_main.view.*

/**
 * Created by wanbo on 2017/7/14.
 */
class MainCardViewType: MoreViewType<MainCard>() {

    override fun getViewLayout(): Int = R.layout.item_view_main

    override fun getViewModel(): KClass<MainCard> = MainCard::class

    override fun bindData(data: MainCard, holder: MoreViewHolder?) {
        holder?.let {
            it.itemView.card_title.text = data.cardTitle
            it.itemView.card_desc.text = data.cardDesc
        }
    }
}