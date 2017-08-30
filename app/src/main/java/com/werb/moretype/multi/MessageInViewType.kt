package com.werb.moretype.multi

import android.support.v7.widget.AppCompatTextView
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.RelativeLayout
import com.facebook.drawee.view.SimpleDraweeView
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import com.werb.moretype.Utils
import kotlinx.android.synthetic.main.item_view_multi_message_in.*


/**
 * Created by wanbo on 2017/7/14.
 */
class MessageInViewType : MoreViewType<Message>(R.layout.item_view_multi_message_in) {

    override fun bindData(data: Message, holder: MoreViewHolder) {
        holder.message_icon.setImageURI(data.icon)
        if (data.showTime) {
            holder.message_time.visibility = View.VISIBLE
            holder.message_time.text = Utils.sendTime(data.time.toLong() * 1000)
        } else {
            holder.message_time.visibility = View.INVISIBLE
        }
        holder.message_content_layout.removeAllViews()
        var currentLayout: RelativeLayout? = null
        when (data.messageType) {
            "text" -> {
                currentLayout = LayoutInflater.from(holder.itemView.context).inflate(R.layout.widget_view_message_in_text, holder.message_content_layout, false) as RelativeLayout
                val text = currentLayout.findViewById<AppCompatTextView>(R.id.message_in_text)
                text.text = data.text
            }
            "image" -> {
                currentLayout = LayoutInflater.from(holder.itemView.context).inflate(R.layout.widget_view_message_in_image, holder.message_content_layout, false) as RelativeLayout
                val image = currentLayout.findViewById<SimpleDraweeView>(R.id.message_in_image)
                image.setImageURI(data.url)
                setImgSize(data.width, data.height, image)
            }
            else -> {

            }
        }
        holder.message_content_layout.addView(currentLayout)
    }

    private fun setImgSize(width: String, height: String, image: SimpleDraweeView) {
        val size = Utils.getIMImageSize(width.toDouble(), height.toDouble())
        val lp = image.layoutParams
        lp.width = size.width
        lp.height = size.height
        image.layoutParams = lp
    }
}