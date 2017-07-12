package com.werb.library.link

import com.werb.library.MoreViewType


/**
 * Created by wanbo on 2017/7/11.
 */
interface MultiLink<T: Any> {

    fun link(data: T): MoreViewType<T>?

}