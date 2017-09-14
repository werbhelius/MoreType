package com.werb.moretype.multi

import android.support.v7.widget.AppCompatTextView
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.facebook.drawee.view.SimpleDraweeView
import com.werb.library.MoreViewHolder
import com.werb.moretype.R
import com.werb.moretype.Utils
import kotlinx.android.synthetic.main.item_view_multi_message_in.*


/**
 * Created by wanbo on 2017/7/14.
 */
class MessageInViewType(containerView: View) : MoreViewHolder<Message>(containerView) {

    override fun bindData(data: Message) {
        message_icon.setImageURI(data.icon)
        if (data.showTime) {
            message_time.visibility = View.VISIBLE
            message_time.text = Utils.sendTime(data.time.toLong() * 1000)
        } else {
            message_time.visibility = View.INVISIBLE
        }
        message_content_layout.removeAllViews()
        var currentLayout: RelativeLayout? = null
        when (data.messageType) {
            "text" -> {
                currentLayout = LayoutInflater.from(containerView.context).inflate(R.layout.widget_view_message_in_text, message_content_layout, false) as RelativeLayout
                val text = currentLayout.findViewById<AppCompatTextView>(R.id.message_in_text)
                text.text = data.text
            }
            "image" -> {
                currentLayout = LayoutInflater.from(containerView.context).inflate(R.layout.widget_view_message_in_image, message_content_layout, false) as RelativeLayout
                val image = currentLayout.findViewById<SimpleDraweeView>(R.id.message_in_image)
                image.setImageURI(data.url)
                setImgSize(data.width, data.height, image)
            }
            else -> {

            }
        }
        message_content_layout.addView(currentLayout)
    }

    private fun setImgSize(width: String, height: String, image: SimpleDraweeView) {
        val size = Utils.getIMImageSize(width.toDouble(), height.toDouble())
        val lp = image.layoutParams
        lp.width = size.width
        lp.height = size.height
        image.layoutParams = lp
    }
}