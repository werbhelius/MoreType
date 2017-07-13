package com.werb.library.extension

import android.animation.Animator
import android.view.View

/**
 * Created by wanbo on 2017/7/13.
 */
interface MoreAnimation {

    fun getItemAnimators(view: View): Array<Animator>

}