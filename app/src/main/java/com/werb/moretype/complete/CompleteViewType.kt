package com.werb.moretype.complete

import android.support.v7.widget.AppCompatTextView
import android.text.TextUtils
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import com.facebook.drawee.view.SimpleDraweeView
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import com.werb.moretype.R
import com.werb.moretype.Utils
import kotlinx.android.synthetic.main.item_view_complete.*

/**
 * Created by wanbo on 2017/7/15.
 */
class CompleteViewType: MoreViewType<Complete>(R.layout.item_view_complete) {

    override fun bindData(data: Complete, holder: MoreViewHolder) {
        holder.icon.setImageURI(data.icon)
        holder.name.text = data.name
        holder.desc.text = data.desc
        holder.time.text = Utils.sendTime(data.time.toLong() * 1000)
        holder.complete_content_layout.removeAllViews()
        if(!TextUtils.isEmpty(data.text)){
            val currentLayout = LayoutInflater.from(holder.itemView.context).inflate(R.layout.widget_view_complete_text, holder.complete_content_layout, false) as RelativeLayout
            val text = currentLayout.findViewById<AppCompatTextView>(R.id.complete_text)
            text.text = data.text
            holder.complete_content_layout.addView(currentLayout)
            val params = currentLayout.layoutParams as LinearLayout.LayoutParams
            params.bottomMargin = 15
        }
        if(!TextUtils.isEmpty(data.image)){
            val currentLayout = LayoutInflater.from(holder.itemView.context).inflate(R.layout.widget_view_message_in_image, holder.complete_content_layout, false) as RelativeLayout
            val image = currentLayout.findViewById<SimpleDraweeView>(R.id.message_in_image)
            image.setImageURI(data.image)
            setImgSize(data.width, data.height, image)
            holder.complete_content_layout.addView(currentLayout)
            val params = currentLayout.layoutParams as LinearLayout.LayoutParams
            params.topMargin = 10
        }

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, " click in ViewType position is " + holder.layoutPosition.toString(), Toast.LENGTH_SHORT).show()
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