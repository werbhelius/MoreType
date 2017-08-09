package com.werb.moretype.complete

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import com.facebook.drawee.view.SimpleDraweeView
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import com.werb.moretype.Utils
import kotlin.reflect.KClass
import kotlinx.android.synthetic.main.item_view_complete.view.*
import kotlinx.android.synthetic.main.item_view_multi_message_in.view.*

/**
 * Created by wanbo on 2017/7/15.
 */
class CompleteViewType: MoreViewType<Complete>(R.layout.item_view_complete, Complete::class) {

    private lateinit var context: Context
    private lateinit var icon: SimpleDraweeView
    private lateinit var name: AppCompatTextView
    private lateinit var desc: AppCompatTextView
    private lateinit var time: AppCompatTextView
    private lateinit var complete_content_layout: LinearLayout

    override fun initView(holder: MoreViewHolder) {
        context = holder.getItemView().context
        icon = holder.findViewOften(R.id.icon)
        name = holder.findViewOften(R.id.name)
        desc = holder.findViewOften(R.id.desc)
        time = holder.findViewOften(R.id.time)
        complete_content_layout = holder.findViewOften(R.id.complete_content_layout)
    }

    override fun bindData(data: Complete, holder: MoreViewHolder) {
        icon.setImageURI(data.icon)
        name.text = data.name
        desc.text = data.desc
        time.text = Utils.sendTime(data.time.toLong() * 1000)
        complete_content_layout.removeAllViews()
        if(!TextUtils.isEmpty(data.text)){
            val currentLayout = LayoutInflater.from(context).inflate(R.layout.widget_view_complete_text, complete_content_layout, false) as RelativeLayout
            val text = currentLayout.findViewById<AppCompatTextView>(R.id.complete_text)
            text.text = data.text
            complete_content_layout.addView(currentLayout)
            val params = currentLayout.layoutParams as LinearLayout.LayoutParams
            params.bottomMargin = 15
        }
        if(!TextUtils.isEmpty(data.image)){
            val currentLayout = LayoutInflater.from(context).inflate(R.layout.widget_view_message_in_image, complete_content_layout, false) as RelativeLayout
            val image = currentLayout.findViewById<SimpleDraweeView>(R.id.message_in_image)
            image.setImageURI(data.image)
            setImgSize(data.width, data.height, image)
            complete_content_layout.addView(currentLayout)
            val params = currentLayout.layoutParams as LinearLayout.LayoutParams
            params.topMargin = 10
        }

        holder.itemView.setOnClickListener {
            Toast.makeText(context, " click in ViewType position is " + holder.layoutPosition.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    fun setImgSize(width: String, height: String, image: SimpleDraweeView) {
        val size = Utils.getIMImageSize(width.toDouble(), height.toDouble())
        val lp = image.layoutParams
        lp.width = size.width
        lp.height = size.height
        image.layoutParams = lp
    }
}