package com.werb.moretype.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.werb.library.MoreAdapter
import com.werb.moretype.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter = MoreAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        more_list.layoutManager = LinearLayoutManager(this)
        adapter.register(MainCardViewType())
                .attachTo(more_list)

        adapter.loadData(MainCard("Single Register", "Register one2one ViewType"))
        adapter.loadData(MainCard("Multi Register", "Register one2more ViewType"))
        adapter.loadData(MainCard("Animation", "Provides five types of Animation"))
        adapter.loadData(MainCard("ItemClick", "Support onItemClick and onItemLongClick"))
        adapter.loadData(MainCard("Complete Example", "A combination of elegant implementation layouts"))
        adapter.loadData(MainCard("About Me", "Developer & Designer"))

    }

}
