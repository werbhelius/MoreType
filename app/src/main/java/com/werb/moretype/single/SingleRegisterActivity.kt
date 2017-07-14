package com.werb.moretype.single

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.werb.library.MoreAdapter
import com.werb.moretype.R
import com.werb.moretype.TitleViewType
import com.werb.moretype.data.DataServer
import kotlinx.android.synthetic.main.activity_single_register.*
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup
import android.support.v7.widget.GridLayoutManager


/**
 * Created by wanbo on 2017/7/14.
 */
class SingleRegisterActivity: AppCompatActivity() {

    private val adapter = MoreAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_register)

        toolbar.setNavigationIcon(R.mipmap.ic_close_white_24dp)
        toolbar.setNavigationOnClickListener { finish() }

        val gridLayoutManager = GridLayoutManager(this, 3)
        val spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                val item = adapter.getData(position)
                return if (item is SingleImage ) 1 else 3
            }
        }
        gridLayoutManager.spanSizeLookup = spanSizeLookup
        single_register_list.layoutManager = gridLayoutManager
        single_register_list.addItemDecoration(SingleItemDecoration(12, spanSizeLookup))
        adapter.register(TitleViewType())
                .register(SingleTypeOneViewType())
                .register(SingleTypeTwoViewType())
                .attachTo(single_register_list)

        adapter.loadData(DataServer.getSingleRegisterData())


    }

}