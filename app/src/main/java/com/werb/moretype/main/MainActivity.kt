package com.werb.moretype.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.werb.library.MoreAdapter
import com.werb.library.action.MoreClickListener
import com.werb.library.link.RegisterItem
import com.werb.moretype.R
import com.werb.moretype.data.DataServer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter = MoreAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter.apply {
            register(RegisterItem(R.layout.item_view_main, MainCardViewHolder::class.java, playLoadClick))
            attachTo(more_list)
        }

        adapter.loadData(DataServer.getMainCardData())

    }

    private val playLoadClick = object : MoreClickListener() {
        override fun onItemClick(view: View, position: Int) {
            if (view.id == R.id.card_playLoad) {
                val payLoad = view.tag as Boolean
                if (payLoad) {
                    adapter.notifyItemChanged(position, PayLoadOne(true))
                } else {
                    adapter.notifyItemChanged(position, PayLoadOne(false))
                }
            }
        }
    }

}
