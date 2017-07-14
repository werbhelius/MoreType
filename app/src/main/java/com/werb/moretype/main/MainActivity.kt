package com.werb.moretype.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.werb.library.MoreAdapter
import com.werb.moretype.R
import com.werb.moretype.data.DataServer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter = MoreAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        more_list.layoutManager = LinearLayoutManager(this)
        adapter.register(MainCardViewType())
                .attachTo(more_list)

        adapter.loadData(DataServer.getMainCardData())

    }

}
