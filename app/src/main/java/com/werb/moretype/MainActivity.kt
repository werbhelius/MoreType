package com.werb.moretype

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.werb.library.action.MoreClickListener
import com.werb.library.MoreAdapter
import com.werb.library.MoreViewType
import com.werb.library.link.MultiLink
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter = MoreAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.layoutManager = LinearLayoutManager(this)
        adapter.attachTo(list)
                .userSoleRegister()
                .register(buildTextViewType())
                .multiRegister(People::class, object : MultiLink<People> {
                    override fun link(data: People): MoreViewType<People>? {
                        if (data.name == "zhangsan") {
                            return buildMessageInViewType()
                        } else if (data.name == "lisi") {
                            return MessageOutViewType()
                        } else return null
                    }
                })


        adapter.loadData(People("zhangsan", 10))
        adapter.loadData(People("lisi", 20))
        adapter.loadData("1")
        adapter.loadData("2")
        adapter.loadData(People("zhangsan", 10))
        adapter.loadData(People("lisi", 20))
        adapter.loadData("3")
        adapter.loadData("4")
        adapter.loadData("5")
        adapter.loadData(People("zhangsan", 10))
        adapter.loadData(People("lisi", 20))
        adapter.loadData("6")
        adapter.loadData("7")
        adapter.loadData(People("zhangsan", 10))
        adapter.loadData(People("lisi", 20))
        adapter.loadData(Footer())

    }

    fun buildTextViewType(): TextViewType {
        val viewType = TextViewType()
        viewType.setMoreClickListener(object : MoreClickListener {
            override fun onItemLongClick(view: View, position: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemClick(view: View, position: Int) {
                when (view.id) {
                    R.id.text -> {
                        Toast.makeText(view.context, position.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }

        })
        return viewType
    }

    fun buildMessageInViewType(): MessageInViewType {
        val viewType = MessageInViewType()
        viewType.setMoreClickListener(object : MoreClickListener {
            override fun onItemLongClick(view: View, position: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemClick(view: View, position: Int) {
                when (view.id) {
                    R.id.message_in_layout -> {
                        Toast.makeText(view.context, "lalalallalala", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        })
        return viewType
    }
}
