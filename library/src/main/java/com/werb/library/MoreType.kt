package com.werb.library

import com.werb.library.link.SoleLinkManager

/**
 * Created by wanbo on 2017/7/12.
 */
object MoreType {

    fun soleRegister(vararg viewTypes: MoreViewType<*>) {
        SoleLinkManager.globalRegister(*viewTypes)
    }

}