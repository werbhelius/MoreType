package com.werb.library.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.werb.library.action.MoreClickListener

/**
 * Created by wanbo on 2017/7/2.
 */
class TestUser: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val viewType = ListViewType()
        viewType.setMoreClickListener(object : MoreClickListener{

            override fun onItemClick(view: View, position: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemLongClick(view: View, position: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }



}