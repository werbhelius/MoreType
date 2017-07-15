package com.werb.moretype.complete

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.werb.library.MoreAdapter
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.library.action.MoreClickListener
import com.werb.moretype.R
import kotlin.reflect.KClass
import kotlinx.android.synthetic.main.item_view_horizontal_list.view.*

/**
 * Created by wanbo on 2017/7/15.
 */
class HorizontalViewType: MoreViewType<HorizontalData>() {

    private val adapter = MoreAdapter()

    override fun getViewLayout(): Int = R.layout.item_view_horizontal_list

    override fun getViewModel(): KClass<HorizontalData> = HorizontalData::class

    override fun bindData(data: HorizontalData, holder: MoreViewHolder) {
        val context = holder.itemView.context
        holder.itemView.icon.setImageURI(data.url)
        holder.itemView.title.text = data.title
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        holder.itemView.horizontal_list.layoutManager = layoutManager
        adapter.register(getHorizontalItemViewType())
                .attachTo(holder.itemView.horizontal_list)
        adapter.removeAllData()
        adapter.loadData(data.list)

        holder.itemView.setOnClickListener {
            Toast.makeText(context, " click in ViewType position is " + holder.layoutPosition.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun getHorizontalItemViewType(): HorizontalItemViewType{

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