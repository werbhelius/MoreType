package com.werb.moretype.complete

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.facebook.drawee.view.SimpleDraweeView
import com.werb.library.MoreAdapter
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.library.action.MoreClickListener
import com.werb.moretype.R
import kotlinx.android.synthetic.main.item_view_horizontal_list.*

/**
 * Created by wanbo on 2017/7/15.
 */
class HorizontalViewType : MoreViewType<HorizontalData>(R.layout.item_view_horizontal_list) {

    private val adapter: MoreAdapter by lazy {
        MoreAdapter().apply {
            register(horizontalItemViewType)
        }
    }
    private lateinit var itemView: View
    private lateinit var context: Context
    private lateinit var icon: SimpleDraweeView
    private lateinit var title: AppCompatTextView
    private lateinit var horizontal_list: RecyclerView
    private val horizontalItemViewType = getHorizontalItemViewType()

    override fun initView(holder: MoreViewHolder) {
        this.itemView = holder.getItemView()
        context = holder.getItemView().context
        icon = holder.findViewOften(R.id.icon)
        title = holder.findViewOften(R.id.title)
        horizontal_list = holder.findViewOften(R.id.horizontal_list)
    }

    override fun bindData(data: HorizontalData, holder: MoreViewHolder) {
        icon.setImageURI(data.url)
        title.text = data.title
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        horizontal_list.layoutManager = layoutManager
        adapter.attachTo(horizontal_list)
        adapter.removeAllData()
        adapter.loadData(data.list)

        itemView.setOnClickListener {
            Toast.makeText(context, " click in ViewType position is " + holder.layoutPosition.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun getHorizontalItemViewType(): HorizontalItemViewType {

        val viewType = HorizontalItemViewType()
        viewType.setMoreClickListener(object : MoreClickListener {

            override fun onItemClick(view: View, position: Int) {
                when (view.id) {
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