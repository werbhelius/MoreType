package com.werb.library

import android.text.TextUtils
import com.google.gson.Gson
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * Created by Stainberg on 11/20/17.
 */

object MoreGson {

    private val gson : Gson = Gson()

    private fun serialize(o : Any):String = gson.toJson(o)

    fun hash(o : Any):String = toMD5(serialize(o))

    private fun toMD5(str: String): String {
        if (TextUtils.isEmpty(str)) {
            return ""
        }
        try {
            val algorithm = MessageDigest.getInstance("MD5")
            algorithm.reset()
            algorithm.update(str.toByteArray())
            return toHexString(algorithm.digest())
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
            throw RuntimeException(e)
        }

    }

    private fun toHexString(bytes: ByteArray): String {
        val hexString = StringBuilder()
        for (i in bytes.indices) {
            var `val` = bytes[i].toInt()
            if (`val` < 0) {
                `val` += 256
            }
            if (`val` < 16) {
                hexString.append("0")
            }
            hexString.append(Integer.toHexString(`val`))
        }
        return hexString.toString()
    }
}