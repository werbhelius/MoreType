package com.werb.library.action


/**
 * Created by wanbo on 2017/7/15.
 */
interface DataAction {

    fun loadData(data: Any)
    fun getData(position: Int): Any
    fun removeAllData()
    fun removeData(data: Any)
    fun removeData(position: Int)

}