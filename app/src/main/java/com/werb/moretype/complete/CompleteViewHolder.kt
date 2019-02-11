package com.werb.moretype.complete

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import com.facebook.drawee.view.SimpleDraweeView
import com.werb.library.MoreViewHolder
import com.werb.moretype.R
import com.werb.moretype.Utils
import kotlinx.android.synthetic.main.item_view_complete.*

/**
 * Created by wanbo on 2017/7/15.
 */
class CompleteViewHolder(values: MutableMap<String, Any>, containerView: View) : MoreViewHolder<Complete>(values, containerView) {

    override fun bindData(data: Complete, payloads: List<Any>) {
        icon.setImageURI(data.icon)
        name.text = data.name
        desc.text = data.desc
        time.text = Utils.sendTime(data.time.toLong() * 1000)
        complete_content_layout.removeAllViews()
        if(!TextUtils.isEmpty(data.text)){
            val currentLayout = LayoutInflater.from(containerView.context).inflate(R.layout.widget_view_complete_text, complete_content_layout, false) as RelativeLayout
            val text = currentLayout.findViewById<AppCompatTextView>(R.id.complete_text)
            text.text = data.text
            complete_content_layout.addView(currentLayout)
            val params = currentLayout.layoutParams as LinearLayout.LayoutParams
            params.bottomMargin = 15
        }
        if(!TextUtils.isEmpty(data.image)){
            val currentLayout = LayoutInflater.from(containerView.context).inflate(R.layout.widget_view_message_in_image, complete_content_layout, false) as RelativeLayout
            val image = currentLayout.findViewById<SimpleDraweeView>(R.id.message_in_image)
            image.setImageURI(data.image)
            setImgSize(data.width, data.height, image)
            complete_content_layout.addView(currentLayout)
            val params = currentLayout.layoutParams as LinearLayout.LayoutParams
            params.topMargin = 10
        }

        itemView.setOnClickListener {
            Toast.makeText(containerView.context, " click in ViewType position is " + layoutPosition.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun setImgSize(width: String, height: String, image: SimpleDraweeView) {
        val size = Utils.getIMImageSize(width.toDouble(), height.toDouble())
        val lp = image.layoutParams
        lp.width = size.width
        lp.height = size.height
        image.layoutParams = lp
    }
}