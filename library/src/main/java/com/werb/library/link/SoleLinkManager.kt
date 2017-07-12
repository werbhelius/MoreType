package com.werb.library.link

import com.werb.library.MoreViewType

/**
 * Created by wanbo on 2017/7/12.
 */
object SoleLinkManager {

    var viewTypes = arrayOf<MoreViewType<*>>()

    fun globalRegister(vararg viewTypes: MoreViewType<*>) {
        @Suppress("UNCHECKED_CAST")
        this.viewTypes = viewTypes as Array<MoreViewType<*>>
    }
    
}