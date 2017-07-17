package com.werb.moretype.me

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.werb.library.MoreAdapter
import com.werb.moretype.R
import com.werb.moretype.TitleViewType
import com.werb.moretype.data.DataServer
import com.werb.moretype.main.MainActivity
import kotlinx.android.synthetic.main.activity_me.*

/**
 * Created by wanbo on 2017/7/15.
 */
class AboutMeActivity: AppCompatActivity() {

    private val adapter = MoreAdapter()
    private var short = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_me)

        short = intent.action == "shortStart"

        toolbar.setNavigationIcon(R.mipmap.ic_close_white_24dp)
        toolbar.setNavigationOnClickListener { onBackPressed() }

        me_list.layoutManager = LinearLayoutManager(this)
        adapter.userSoleRegister()
                .register(TitleViewType())
                .register(MeInfoViewType())
                .register(MeTitleViewType())
                .register(MeMessageViewType())
                .register(MeThanksViewType())
                .renderWithAnimation()
                .startAnimPosition(1)
                .attachTo(me_list)

        adapter.loadData(DataServer.getAboutMeData())
        me_list.smoothScrollToPosition(0)
    }

    override fun onBackPressed() {
        if(!short){
            finish()
        } else {
            startActivity(Intent(AboutMeActivity@this, MainActivity::class.java))
            finish()
        }
    }

}