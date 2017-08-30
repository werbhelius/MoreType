package com.werb.moretype.multi

import android.net.Uri
import android.support.v7.widget.AppCompatTextView
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.facebook.drawee.view.SimpleDraweeView
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import com.werb.moretype.Utils
import kotlinx.android.synthetic.main.item_view_multi_message_out.*


/**
 * Created by wanbo on 2017/7/14.
 */
class MessageOutViewType : MoreViewType<Message>(R.layout.item_view_multi_message_out) {

    override fun bindData(data: Message, holder: MoreViewHolder) {

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
                currentLayout = LayoutInflater.from(holder.itemView.context).inflate(R.layout.widget_view_message_out_text, holder.message_content_layout, false) as RelativeLayout
                val text = currentLayout.findViewById<AppCompatTextView>(R.id.message_out_text)
                text.text = data.text
            }
            "image" -> {
                currentLayout = LayoutInflater.from(holder.itemView.context).inflate(R.layout.widget_view_message_out_image, holder.message_content_layout, false) as RelativeLayout
                val image = currentLayout.findViewById<SimpleDraweeView>(R.id.message_out_image)
                if (data.url.startsWith("http")){
                    image.setImageURI(data.url)
                }else {
                    val uri = Uri.parse("file://" + data.url)
                    image.setImageURI(uri)
                }
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