package com.werb.moretype

import android.graphics.BitmapFactory
import com.werb.moretype.multi.ImageSize
import java.io.File
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by wanbo on 2017/7/14.
 */
object Utils {

    fun sendTime(ms: Long): String {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = ms
        val format = SimpleDateFormat("MM/dd HH:mm")
        return format.format(Date(ms))
    }

    fun dp2px(dpValue: Float): Int {
        val scale = MyApp.myApp.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    fun getIMImageSize(width: Double, height: Double): ImageSize {
        val fixWidth: Int
        val fixHeight: Int
        var ratio = width.toFloat() / height.toFloat()
        if (ratio > 1) {
            if (ratio > 3) {
                ratio = 3f
            }
            fixWidth = dp2px(200f)
            fixHeight = (fixWidth / ratio).toInt()
        } else {
            if (ratio < 0.3) {
                ratio = 0.3f
            }
            fixHeight = dp2px(200f)
            fixWidth = (ratio * fixHeight).toInt()
        }
        return ImageSize(fixWidth, fixHeight)
    }

    fun readImageSize(path: String): ImageSize?{
        val orFile = File(path)
        if (!orFile.exists()) {
            return null
        }
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeFile(orFile.absolutePath, options)
        return ImageSize(options.outWidth, options.outHeight )
    }

}