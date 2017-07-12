package com.werb.moretype

import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import kotlin.reflect.KClass

/**
 * Created by wanbo on 2017/7/12.
 */
class FooterViewType: MoreViewType<Footer>() {
    override fun getViewLayout(): Int = R.layout.item_view_footer

    override fun getViewModel(): KClass<Footer> = Footer::class

    override fun bindData(t: Footer, holder: MoreViewHolder?) {

    }
}