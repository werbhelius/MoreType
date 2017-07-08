package com.werb.moretype

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
        adapter.loadData("6")
        adapter.loadData("7")
        adapter.loadData("8")
        adapter.loadData("9")
        adapter.loadData("10")
        adapter.loadData("11")
        adapter.loadData("12")
        adapter.loadData("13")
        adapter.loadData("14")
        adapter.loadData("15")
        adapter.loadData("16")

//        list.postDelayed({
//            val childView = viewType.getChildView(R.id.text)
//            childView?.setOnClickListener { Toast.makeText(MainActivity@ this, "111" ,Toast.LENGTH_SHORT ).show()  }
//        },5000)

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
