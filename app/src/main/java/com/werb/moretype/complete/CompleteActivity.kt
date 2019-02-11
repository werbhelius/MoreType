package com.werb.moretype.complete

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.werb.library.MoreAdapter
import com.werb.library.link.RegisterItem
import com.werb.moretype.R
import com.werb.moretype.TitleViewHolder
import com.werb.moretype.anim.AnimViewHolder
import com.werb.moretype.data.DataServer
import com.werb.moretype.main.MainCard
import kotlinx.android.synthetic.main.activity_complete.*


/**
 * Created by wanbo on 2017/7/15.
 */
class CompleteActivity : AppCompatActivity() {

    private val adapter = MoreAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete)

        toolbar.setNavigationIcon(R.mipmap.ic_close_white_24dp)
        toolbar.setNavigationOnClickListener { finish() }

        complete_list.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        adapter.apply {
            userSoleRegister()
            register(RegisterItem(R.layout.item_view_title, TitleViewHolder::class.java))
            register(RegisterItem(R.layout.item_view_anim, AnimViewHolder::class.java))
            register(RegisterItem(R.layout.item_view_complete, CompleteViewHolder::class.java))
            register(RegisterItem(R.layout.item_view_horizontal_list, HorizontalViewHolder::class.java))
            renderWithAnimation()
                    .startAnimPosition(1)
                    .attachTo(complete_list)
        }

        adapter.loadData(MainCard("Complete Example", "A combination of elegant implementation layouts with refresh and loadMore"))
        adapter.loadData(DataServer.getCompleteData())

        //refresh
        refresh.setOnRefreshListener {
            adapter.removeDataFromIndex(1)
            adapter.loadData(DataServer.getCompleteData())
            refresh.isRefreshing = false
        }

        //loadMore
        complete_list.addOnScrollListener(loadMoreListener)
    }

    /** [OnLoadMoreListener] this is a sample by use OnScrollListener  to achieve loadMore Data*/
    private val loadMoreListener = object : OnLoadMoreListener() {

        override fun isHasMore(): Boolean = true

        override fun onLoadMore(v: View) {
            v.postDelayed({
                val any = adapter.getData(adapter.itemCount - 1)
                if (any is Footer) {
                    adapter.removeData(any)
                    isShowFooter = false
                    adapter.loadData(DataServer.getCompleteData())
                }
            }, 500)
        }

        override fun showFooter(v: View) {
            if (!isShowFooter) {
                isShowFooter = true
                if (adapter.itemCount > 0 && adapter.getData(adapter.itemCount - 1) !is Footer) {
                    val footer = Footer()
                    adapter.loadData(footer)
                }
            }
        }

    }

    companion object {
        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, CompleteActivity::class.java))
        }
    }

}