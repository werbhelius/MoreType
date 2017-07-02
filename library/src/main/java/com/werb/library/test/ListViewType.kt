package com.werb.library.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.library.R

/**
 * Created by wanbo on 2017/7/2.
 */
class ListViewType: MoreViewType<String, ListViewType.ListViewHolder>() {

    override fun getViewLayout(): Int {
        return R.layout.widget_view_item_test
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ListViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ListViewHolder, t: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun build(holder: ListViewHolder) {
        super.build(holder)
    }

    class ListViewHolder(itemView: View?) : MoreViewHolder(itemView){



    }

}