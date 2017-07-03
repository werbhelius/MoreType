package com.werb.library.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
        val layout = inflater.inflate(getViewLayout(), parent, false)
        return ListViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ListViewHolder, t: String) {
        holder.bindData(t)
    }

    class ListViewHolder(itemView: View) : MoreViewHolder(itemView){

        private var button:Button = itemView.findViewById(R.id.button)

        fun bindData(t: String){
            addOnClickListener(R.id.button)

        }

    }

}