package com.werb.moretype.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.werb.library.MoreAdapter
import com.werb.library.action.MoreClickListener
import com.werb.moretype.R
import com.werb.moretype.data.DataServer
import com.werb.moretype.single.SingleRegisterActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter = MoreAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter.apply {
            register(R.layout.item_view_main, MainCardViewHolder::class.java)
            attachTo(more_list)
        }

        adapter.loadData(DataServer.getMainCardData())

    }

}
