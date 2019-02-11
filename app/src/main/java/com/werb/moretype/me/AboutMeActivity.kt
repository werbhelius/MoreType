package com.werb.moretype.me

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.werb.library.MoreAdapter
import com.werb.library.link.RegisterItem
import com.werb.moretype.R
import com.werb.moretype.TitleViewHolder
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

        me_list.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        adapter.apply {
            userSoleRegister()
            register(RegisterItem(R.layout.item_view_title, TitleViewHolder::class.java))
            register(RegisterItem(R.layout.item_view_about_me_info, MeInfoViewHolder::class.java))
            register(RegisterItem(R.layout.item_view_about_me_title, MeTitleViewType::class.java))
            register(RegisterItem(R.layout.item_view_about_me_message, MeMessageViewHolder::class.java))
            register(RegisterItem(R.layout.item_view_about_me_thx, MeThanksViewHolder::class.java))
            renderWithAnimation()
            startAnimPosition(1)
            attachTo(me_list)
        }

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

    companion object {
        fun startActivity(activity: Activity){
            activity.startActivity(Intent(activity, AboutMeActivity::class.java))
        }
    }

}