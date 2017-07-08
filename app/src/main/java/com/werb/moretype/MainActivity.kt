package com.werb.moretype

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.werb.library.action.MoreClickListener
import com.werb.library.MoreAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter = MoreAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.layoutManager = LinearLayoutManager(this)
        val viewType = buildTextViewType()
        adapter.attachTo(list)
                .register(viewType)

        adapter.loadData("1")
        adapter.loadData("2")
        adapter.loadData("3")
        adapter.loadData("4")
        adapter.loadData("5")

    }

    fun buildTextViewType(): TextViewType {
        val viewType = TextViewType()
        viewType.setMoreClickListener(object : MoreClickListener {
            override fun onItemLongClick(view: View, position: Int){}

            override fun onItemClick(view: View, position: Int) {
                when(view.id){
                    R.id.text -> {  Toast.makeText(view.context, position.toString() ,Toast.LENGTH_SHORT ).show() }
                }
            }

        })
        return viewType
    }
}
