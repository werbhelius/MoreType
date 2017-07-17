package com.werb.library.action

import com.werb.library.MoreViewHolder

/**
 * [Action] Define Action we need
 * Created by wanbo on 2017/7/3.
 */
interface Action {

    /** [bindHolder] bind holder with action */
    fun bindHolder(holder: MoreViewHolder)

    /** [setMoreClickListener] deal with click and longClick */
    fun setMoreClickListener(listener: MoreClickListener)

}