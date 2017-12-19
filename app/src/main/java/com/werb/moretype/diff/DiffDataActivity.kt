package com.werb.moretype.diff

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import com.werb.library.MoreAdapter
import com.werb.library.link.RegisterItem
import com.werb.moretype.R
import com.werb.moretype.TitleViewHolder
import com.werb.moretype.anim.AnimViewHolder
import com.werb.moretype.complete.CompleteViewHolder
import com.werb.moretype.data.DataServer
import com.werb.moretype.main.MainCard
import kotlinx.android.synthetic.main.activity_diff.*
import android.support.v7.widget.DefaultItemAnimator



/**
 * Created by wanbo on 2017/12/19.
 */
class DiffDataActivity : AppCompatActivity() {

    private val adapter = MoreAdapter()
    private val newList = mutableListOf<Any>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diff)

        toolbar.setNavigationIcon(R.mipmap.ic_close_white_24dp)
        toolbar.setNavigationOnClickListener { finish() }

        diff_list.layoutManager = LinearLayoutManager(this)
        adapter.apply {
            userSoleRegister()
            register(RegisterItem(R.layout.item_view_title, TitleViewHolder::class.java))
            register(RegisterItem(R.layout.item_view_anim, AnimViewHolder::class.java))
            register(RegisterItem(R.layout.item_view_complete, CompleteViewHolder::class.java))
            attachTo(diff_list)
        }

        adapter.loadData(MainCard("Diff Data", "Diff data when refresh and loadMore"))
        adapter.loadData(DataServer.getDiffData1())
        (diff_list.itemAnimator as DefaultItemAnimator).supportsChangeAnimations = false

        //refresh
        refresh.setOnRefreshListener {
            adapter.refresh(1, newList, DiffDataCallback::class.java)
            refresh.isRefreshing = false
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                when (position) {
                    0 -> {
                        newList.clear()
                        newList.addAll(DataServer.getDiffData1())
                    }
                    1 -> {
                        newList.clear()
                        newList.addAll(DataServer.getDiffData2())
                    }
                    2 -> {
                        newList.clear()
                        newList.addAll(DataServer.getDiffData3())
                    }
                    3 -> {
                        newList.clear()
                        newList.addAll(adapter.list.subList(1, adapter.itemCount))
                    }
                }
            }

        }
    }

    companion object {
        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, DiffDataActivity::class.java))
        }
    }

}