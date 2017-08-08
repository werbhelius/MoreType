package com.werb.moretype

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

    private val title = itemView.title
    private val desc = itemView.desc

    override fun bindData(data: MainCard, holder: MoreViewHolder) {
        title.text = data.cardTitle
        desc.desc.text = data.cardDesc
    }
}