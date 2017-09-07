package com.werb.library

import android.view.LayoutInflater
import android.view.ViewGroup
import com.werb.library.action.MoreAction
import java.lang.reflect.ParameterizedType


/**
 * [MoreViewType] link with model
 * Created by wanbo on 2017/7/2.
 */
abstract class MoreViewType<T : Any>(internal val layoutId: Int) : MoreAction() {

    internal var clazz: Class<T>

    init {
        val type = this.javaClass.genericSuperclass as ParameterizedType
        val p = type.actualTypeArguments
        @Suppress("UNCHECKED_CAST")
        clazz = p[0] as Class<T>
    }

    /** [initView] find view  */
    abstract fun initView(holder: MoreViewHolder)

    /** [bindData] bind data with T  */
    abstract fun bindData(data: T, holder: MoreViewHolder)

    /** [unBindData] unbind and release resources*/
    open fun unBindData(holder: MoreViewHolder) {}

    /** [onCreateViewHolder] just like onCreateViewHolder() in RecyclerView.Adapter  */
    internal fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): MoreViewHolder {
        val view = inflater.inflate(layoutId, parent, false)
        return MoreViewHolder(view)
    }

}