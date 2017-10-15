package com.werb.moretype.complete

import android.view.View
import android.widget.Toast
import com.werb.library.MoreAdapter
import com.werb.library.MoreViewHolder
import com.werb.library.action.MoreClickListener
import com.werb.library.link.RegisterItem
import com.werb.moretype.R
import kotlinx.android.synthetic.main.item_view_horizontal_list.*

/**
 * Created by wanbo on 2017/7/15.
 */
class HorizontalViewHolder(containerView: View) : MoreViewHolder<HorizontalData>(containerView) {

    private val adapter: MoreAdapter by lazy {
        MoreAdapter().apply {
            register(RegisterItem(R.layout.item_view_horizontal_item, HorizontalItemViewHolder::class.java, click))
            attachTo(horizontal_list)
        }
    }

    override fun bindData(data: HorizontalData, payloads: List<Any>) {
        icon.setImageURI(data.url)
        title.text = data.title
        adapter.removeAllData()
        adapter.loadData(data.list)
        itemView.setOnClickListener {
            Toast.makeText(containerView.context, " click in ViewType position is " + layoutPosition.toString(), Toast.LENGTH_SHORT).show()
        }
    }


    val click = object : MoreClickListener() {
        override fun onItemClick(view: View, position: Int) {
            when (view.id) {
                R.id.close -> {
                    adapter.removeData(position)
                }
            }
        }

    }

}