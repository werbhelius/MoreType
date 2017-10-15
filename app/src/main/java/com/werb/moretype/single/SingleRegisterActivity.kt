package com.werb.moretype.single

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.werb.library.MoreAdapter
import com.werb.moretype.R
import com.werb.moretype.TitleViewHolder
import com.werb.moretype.data.DataServer
import kotlinx.android.synthetic.main.activity_single_register.*
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup
import android.support.v7.widget.GridLayoutManager
import com.werb.library.link.RegisterItem


/**
 * Created by wanbo on 2017/7/14.
 */
class SingleRegisterActivity : AppCompatActivity() {

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
                return if (item is SingleImage) 1 else 3
            }
        }
        gridLayoutManager.spanSizeLookup = spanSizeLookup
        single_register_list.layoutManager = gridLayoutManager
        single_register_list.addItemDecoration(SingleItemDecoration(12))

        /* register viewType and attach to recyclerView */
        adapter.apply {
            register(RegisterItem(R.layout.item_view_single_type_one, SingleTypeOneViewHolder::class.java))
            register(RegisterItem(R.layout.item_view_single_type_two, SingleTypeTwoViewHolder::class.java))
            register(RegisterItem(R.layout.item_view_title, TitleViewHolder::class.java))
            attachTo(single_register_list)
        }

        /* load any data List or model object */
        adapter.loadData(DataServer.getSingleRegisterData())

    }

    companion object {
        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, SingleRegisterActivity::class.java))
        }
    }

}