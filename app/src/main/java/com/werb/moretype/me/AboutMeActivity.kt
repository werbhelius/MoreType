package com.werb.moretype.me

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.werb.library.MoreAdapter
import com.werb.moretype.R
import com.werb.moretype.TitleViewType
import com.werb.moretype.data.DataServer
import kotlinx.android.synthetic.main.activity_me.*

/**
 * Created by wanbo on 2017/7/15.
 */
class AboutMeActivity: AppCompatActivity() {

    private val adapter = MoreAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_me)

        toolbar.setNavigationIcon(R.mipmap.ic_close_white_24dp)
        toolbar.setNavigationOnClickListener { finish() }

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

}