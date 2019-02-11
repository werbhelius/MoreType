package com.werb.moretype.anim

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import com.werb.library.MoreAdapter
import com.werb.library.extension.*
import com.werb.library.link.RegisterItem
import com.werb.moretype.R
import com.werb.moretype.TitleViewHolder
import com.werb.moretype.data.DataServer
import kotlinx.android.synthetic.main.activity_anim.*


/**
 * Created by wanbo on 2017/7/15.
 */
class AnimActivity : AppCompatActivity() {

    private val adapter = MoreAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim)

        toolbar.setNavigationIcon(R.mipmap.ic_close_white_24dp)
        toolbar.setNavigationOnClickListener { finish() }

        anim_list.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        adapter.apply {
            register(RegisterItem(R.layout.item_view_title, TitleViewHolder::class.java))
            register(RegisterItem(R.layout.item_view_anim, AnimViewHolder::class.java))
            startAnimPosition(1)
        }

        switch_view.setOnCheckedChangeListener({ _: CompoundButton, check: Boolean ->
            adapter.firstShowAnim(check)
        })

        spinner.onItemSelectedListener = object : OnItemSelectedListener {

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                when (position) {
                    0 -> {
                        adapter.removeAllData()
                        adapter.renderWithAnimation(AlphaAnimation())
                        adapter.loadData(DataServer.getAnimData())
                        adapter.attachTo(anim_list)
                    }
                    1 -> {
                        adapter.removeAllData()
                        adapter.renderWithAnimation(ScaleInAnimation())
                        adapter.loadData(DataServer.getAnimData())
                        adapter.attachTo(anim_list)
                    }
                    2 -> {
                        adapter.removeAllData()
                        adapter.renderWithAnimation(SlideInLeftAnimation())
                        adapter.loadData(DataServer.getAnimData())
                        adapter.attachTo(anim_list)
                    }
                    3 -> {
                        adapter.removeAllData()
                        adapter.renderWithAnimation(SlideInRightAnimation())
                        adapter.loadData(DataServer.getAnimData())
                        adapter.attachTo(anim_list)
                    }
                    4 -> {
                        adapter.removeAllData()
                        adapter.renderWithAnimation(SlideInBottomAnimation())
                        adapter.loadData(DataServer.getAnimData())
                        adapter.attachTo(anim_list)
                    }
                }
            }

        }
    }

    companion object {

        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, AnimActivity::class.java))
        }
    }

}