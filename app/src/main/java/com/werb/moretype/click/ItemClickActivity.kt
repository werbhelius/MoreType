package com.werb.moretype.click

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.werb.library.MoreAdapter
import com.werb.library.action.MoreClickListener
import com.werb.library.link.RegisterItem
import com.werb.library.link.MultiLink
import com.werb.moretype.R
import com.werb.moretype.TitleViewHolder
import com.werb.moretype.data.DataServer
import kotlinx.android.synthetic.main.activity_item_click.*


/**
 * Created by wanbo on 2017/7/15.
 */
class ItemClickActivity : AppCompatActivity() {

    private val adapter = MoreAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_click)

        toolbar.setNavigationIcon(R.mipmap.ic_close_white_24dp)
        toolbar.setNavigationOnClickListener { finish() }

        item_click_list.layoutManager = LinearLayoutManager(this)
        adapter.apply {
            register(R.layout.item_view_title, TitleViewHolder::class.java)
            multiRegister(object : MultiLink<ItemClick>() {
                override fun link(data: ItemClick): RegisterItem {
                    return if (data.click) {
                        RegisterItem(R.layout.item_view_click_one, ItemClickOneViewHolder::class.java, oneClick)
                    } else {
                        RegisterItem(R.layout.item_view_click_one, ItemClickTwoViewHolder::class.java, twoClick)
                    }
                }
            })
            attachTo(item_click_list)
        }

        adapter.loadData(DataServer.getItemClickData())
    }


    private val oneClick = object : MoreClickListener() {
        override fun onItemClick(view: View, position: Int) {
            when (view.id) {
                R.id.icon -> {
                    val url = view.tag as String
                    Toast.makeText(view.context, "click icon in Activity icon url is " + url, Toast.LENGTH_SHORT).show()
                }
                R.id.button -> {
                    Toast.makeText(view.context, "click button in Activity position is " + position.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }

        override fun onItemLongClick(view: View, position: Int): Boolean {
            return false
        }
    }

    private val twoClick = object : MoreClickListener() {
        override fun onItemClick(view: View, position: Int) {
            when (view.id) {
                R.id.icon -> {
                    val url = view.tag as String
                    Toast.makeText(view.context, "click icon in Activity icon url is " + url, Toast.LENGTH_SHORT).show()
                }
            }
        }

        override fun onItemLongClick(view: View, position: Int): Boolean {
            when (view.id) {
                R.id.button -> {
                    AlertDialog.Builder(view.context)
                            .setTitle("Button click in Activity position is " + position.toString())
                            .setPositiveButton("sure", { _: DialogInterface, _: Int -> })
                            .show()
                }
            }
            return false
        }
    }

    companion object {
        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, ItemClickActivity::class.java))
        }
    }

}