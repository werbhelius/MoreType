package com.werb.moretype

import android.view.View
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.main.MainCard
import kotlin.reflect.KClass
import kotlinx.android.synthetic.main.item_view_title.view.*

/**
 * Created by wanbo on 2017/7/14.
 */
class TitleViewType: MoreViewType<MainCard>() {

    override fun getViewLayout(): Int = R.layout.item_view_title

    override fun getViewModel(): KClass<MainCard> = MainCard::class

    override fun bindData(data: MainCard, holder: MoreViewHolder) {
        holder.itemView.title.text = data.cardTitle
        holder.itemView.desc.text = data.cardDesc
    }
}