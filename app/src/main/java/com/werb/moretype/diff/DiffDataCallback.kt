package com.werb.moretype.diff

import com.werb.library.link.XDiffCallback
import com.werb.moretype.anim.AnimType
import com.werb.moretype.complete.Complete
import com.werb.moretype.main.MainCard

/**
 * Created by wanbo on 2017/12/19.
 */
class DiffDataCallback(oldItem: List<Any>, newItem: List<Any>) : XDiffCallback(oldItem, newItem) {

    override fun getOldListSize(): Int = oldItem.size

    override fun getNewListSize(): Int = newItem.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = oldItem[oldItemPosition]
        val new = newItem[newItemPosition]
        if (old is Complete && new is Complete) {
            return old.name == new.name
        } else if (old is AnimType && new is AnimType) {
            return old.title == new.title
        } else if (old is MainCard && new is MainCard) {
            return old.cardTitle == new.cardTitle
        }

        return false
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = oldItem[oldItemPosition]
        val new = newItem[newItemPosition]
        if (old is Complete && new is Complete) {
            return old.desc == new.desc
        } else if (old is AnimType && new is AnimType) {
            return old.thumb == new.thumb
        } else if (old is MainCard && new is MainCard) {
            return old.cardDesc == new.cardDesc
        }

        return false
    }
}