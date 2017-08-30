package com.werb.moretype.complete

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.werb.library.MoreAdapter
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.library.action.MoreClickListener
import com.werb.moretype.R
import kotlinx.android.synthetic.main.item_view_horizontal_list.*

/**
 * Created by wanbo on 2017/7/15.
 */
class HorizontalViewType: MoreViewType<HorizontalData>(R.layout.item_view_horizontal_list) {

    override fun bindData(data: HorizontalData, holder: MoreViewHolder) {
        val adapter = MoreAdapter()
        holder.icon.setImageURI(data.url)
        holder.title.text = data.title
        val layoutManager = LinearLayoutManager(holder.itemView.context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        holder.horizontal_list.layoutManager = layoutManager
        adapter.register(getHorizontalItemViewType(adapter))
                .attachTo(holder.horizontal_list)
        adapter.removeAllData()
        adapter.loadData(data.list)

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, " click in ViewType position is " + holder.layoutPosition.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun getHorizontalItemViewType(adapter: MoreAdapter): HorizontalItemViewType{

        val viewType = HorizontalItemViewType()
        viewType.setMoreClickListener(object : MoreClickListener{

            override fun onItemClick(view: View, position: Int) {
                when(view.id){
                    R.id.close -> {
                        adapter.removeData(position)
                    }
                }
            }

            override fun onItemLongClick(view: View, position: Int): Boolean {
                return false
            }

        })
        return viewType
    }

}