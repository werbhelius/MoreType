package com.werb.moretype.complete

import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import kotlin.reflect.KClass

/**
 * Created by wanbo on 2017/7/15.
 */
class FoorViewType: MoreViewType<Footer>() {

    override fun getViewLayout(): Int = R.layout.item_view_footer

    override fun getViewModel(): KClass<Footer> = Footer::class

    override fun bindData(data: Footer, holder: MoreViewHolder) {

    }
}