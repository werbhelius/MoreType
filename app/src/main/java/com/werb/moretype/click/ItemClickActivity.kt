package com.werb.moretype.click

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.werb.library.MoreAdapter
import com.werb.library.action.MoreClickListener
import com.werb.moretype.R
import com.werb.moretype.TitleViewType
import com.werb.moretype.data.DataServer
import kotlinx.android.synthetic.main.activity_item_click.*
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import com.werb.library.MoreViewType
import com.werb.library.link.MultiLink


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
        adapter.register(TitleViewType())
                .multiRegister(ItemClick::class, object : MultiLink<ItemClick> {
                    override fun link(data: ItemClick): MoreViewType<ItemClick>? {
                        if (data.click) {
                            return buildItemClickOneViewType()
                        } else {
                            return buildItemClickTwoViewType()
                        }
                    }
                })
                .attachTo(item_click_list)

        adapter.loadData(DataServer.getItemClickData())
    }

    private fun buildItemClickOneViewType(): ItemClickOneViewType {
        val viewType = ItemClickOneViewType()
        viewType.setMoreClickListener(object : MoreClickListener {
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
        })
        return viewType
    }

    private fun buildItemClickTwoViewType(): ItemClickTwoViewType {
        val viewType = ItemClickTwoViewType()
        viewType.setMoreClickListener(object : MoreClickListener {
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
        })
        return viewType
    }

}