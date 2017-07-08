package com.werb.moretype

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.werb.library.MoreViewHolder
import com.werb.library.MoreViewType
import kotlin.reflect.KClass
import kotlinx.android.synthetic.main.item_view_string.view.*

/**
 * Created by wanbo on 2017/7/8.
 */
class TextViewType: MoreViewType<String, TextViewType.TextViewHolder>() {

    override fun getViewLayout(): Int = R.layout.item_view_string


    override fun getViewModel(): KClass<String> {
        return String::class
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): TextViewHolder {
        val inflate = inflater.inflate(getViewLayout(), parent, false)
        return TextViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: TextViewHolder, t: String) {
        holder.bindData(t)
    }

    class TextViewHolder(itemView: View) : MoreViewHolder(itemView){

        fun bindData(t: String){
            itemView.text.text = t
            addOnClickListener(itemView.text)
        }

    }

}