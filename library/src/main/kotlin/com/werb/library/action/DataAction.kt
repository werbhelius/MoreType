package com.werb.library.action


/**
 * Action of Data in Adapter
 * Created by wanbo on 2017/7/15.
 */
interface DataAction {

    /** [loadData] add data */
    fun loadData(data: Any)

    /** [loadData] add data */
    fun loadData(index: Int ,data: Any)

    /** [getData] get data by position */
    fun getData(position: Int): Any

    /** [removeAllData] remove all data */
    fun removeAllData()

    /** [removeAllNotRefresh] remove all data not notifyDataSetChanged */
    fun removeAllNotRefresh()

    /** [removeData] remove data by item object */
    fun removeData(data: Any)

    /** [removeData] remove data by position */
    fun removeData(position: Int)

    /** [replaceData] replace data by position */
    fun replaceData(position: Int, data: Any)

}