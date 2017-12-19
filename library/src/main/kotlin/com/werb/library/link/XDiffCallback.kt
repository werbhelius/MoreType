package com.werb.library.link

import android.support.v7.util.DiffUtil

/**
 * Created by wanbo on 2017/12/19.
 */
abstract class XDiffCallback(val oldItem: List<Any>, val newItem: List<Any>) : DiffUtil.Callback()