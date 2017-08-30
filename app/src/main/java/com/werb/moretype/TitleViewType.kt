package com.werb.moretype

import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.main.MainCard
import kotlinx.android.synthetic.main.item_view_title.*

/**
 * Created by wanbo on 2017/7/14.
 */
class TitleViewType: MoreViewType<MainCard>(R.layout.item_view_title) {

    override fun bindData(data: MainCard, holder: MoreViewHolder) {
        holder.title.text = data.cardTitle
        holder.desc.text = data.cardDesc
    }
}