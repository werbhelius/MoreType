package com.werb.library.link

import com.werb.library.MoreViewType


/**
 * [MultiLink] one2more case in model with ViewType
 * Created by wanbo on 2017/7/11.
 */
interface MultiLink<T: Any> {

    /** [link] return one ViewType by judge data */
    fun link(data: T): MoreViewType<T>

}