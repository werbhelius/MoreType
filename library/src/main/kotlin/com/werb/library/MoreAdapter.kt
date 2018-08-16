package com.werb.library

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import com.werb.library.action.DataAction
import com.werb.library.action.MoreClickListener
import com.werb.library.extension.AlphaAnimation
import com.werb.library.extension.AnimExtension
import com.werb.library.extension.MoreAnimation
import com.werb.library.link.*
import android.support.v7.util.DiffUtil
import android.util.Log
import com.werb.library.exception.ViewHolderInitErrorException
import com.werb.library.link.XDiffCallback
import com.werb.library.scroll.IAdapterScrollMonitor
import com.werb.library.scroll.IViewHolderScrollMonitor
import java.lang.ref.SoftReference


/**
 * [MoreAdapter] build viewHolder with data
 * Created by wanbo on 2017/7/2.
 */
class MoreAdapter : Adapter<MoreViewHolder<Any>>(), MoreLink, AnimExtension, DataAction, IAdapterScrollMonitor {

    val list: MutableList<Any> = mutableListOf()
    private val linkManager: MoreLink by lazy { MoreLinkManager() }
    private var animation: MoreAnimation? = null
    private var animDuration = 250L
    private var startAnimPosition = 0
    private var firstShow = false
    private var lastAnimPosition = -1
    private var linearInterpolator = LinearInterpolator()
    private var recyclerViewSoft: SoftReference<RecyclerView>? = null

    private var visibleHolders: MutableList<IViewHolderScrollMonitor>? = null
    private val TAG = "ScrollMonitor"
    //上次滑动方向
    private var scrollUp:Boolean = true
    //是否按滑动方向分发事件
    private var direction = true

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoreViewHolder<Any> {
        val viewHolderClass = createViewHolder(viewType)
        val con = viewHolderClass.getConstructor(View::class.java)
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        var moreViewHolder: MoreViewHolder<Any>? = null
        try {
            moreViewHolder = con.newInstance(view) as MoreViewHolder<Any>
        } catch (e: Exception) {
            e.printStackTrace()
            if (moreViewHolder == null) {
                throw ViewHolderInitErrorException(viewHolderClass.simpleName, e.cause?.message ?: "")
            }
        }
        return moreViewHolder!!
    }

    override fun onBindViewHolder(holder: MoreViewHolder<Any>, position: Int) {
        val any = list[position]
        holder.clickListener = bindClickListener(holder)
        holder.bindData(any)
    }

    override fun onBindViewHolder(holder: MoreViewHolder<Any>, position: Int, payloads: MutableList<Any>) {
        if (payloads.isNotEmpty()) {
            val any = list[position]
            holder.clickListener = bindClickListener(holder)
            holder.bindData(any, payloads)
        } else {
            onBindViewHolder(holder, position)
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun onViewRecycled(holder: MoreViewHolder<Any>) {
        holder.unBindData()
    }

    fun attachTo(view: RecyclerView): MoreLink {
        view.adapter = this
        recyclerViewSoft = SoftReference(view)
        return this
    }

    @Suppress("UNCHECKED_CAST")
    override fun refresh(index: Int, newData: Any, diffUtilClazz: Class<out XDiffCallback>) {
        val newList = mutableListOf<Any>()
        val fixList = list.subList(0, index)
        val diff = diffUtilClazz.getConstructor(List::class.java, List::class.java)
        newList.addAll(fixList)
        if (newData is List<*>) {
            newList.addAll(newData as Collection<Any>)
        } else {
            newList.add(newData)
        }
        val diffCallback = diff.newInstance(list, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(newList)
        recyclerViewSoft?.get()?.apply {
            val state = this.layoutManager.onSaveInstanceState()
            diffResult.dispatchUpdatesTo(this@MoreAdapter)
            this.layoutManager.onRestoreInstanceState(state)
        } ?: run {
            diffResult.dispatchUpdatesTo(this@MoreAdapter)
        }
    }

    override fun getDataIndex(data: Any): Int = list.indexOf(data)

    @Suppress("UNCHECKED_CAST")
    override fun loadData(data: Any) {
        if (data is List<*>) {
            var position = 0
            if (list.size > 0) {
                position = list.size
            }
            list.addAll(position, data as Collection<Any>)
            recyclerViewSoft?.get()?.apply {
                val state = this.layoutManager.onSaveInstanceState()
                notifyItemRangeInserted(position, data.size)
                this.layoutManager.onRestoreInstanceState(state)
            } ?: run {
                notifyItemRangeInserted(position, data.size)
            }
        } else {
            list.add(data)
            recyclerViewSoft?.get()?.apply {
                val state = this.layoutManager.onSaveInstanceState()
                notifyItemInserted(itemCount - 1)
                this.layoutManager.onRestoreInstanceState(state)
            } ?: run {
                notifyItemInserted(itemCount - 1)
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun loadData(index: Int, data: Any) {
        if (data is List<*>) {
            list.addAll(index, data as Collection<Any>)
            recyclerViewSoft?.get()?.apply {
                val state = this.layoutManager.onSaveInstanceState()
                notifyItemRangeInserted(index, data.size)
                this.layoutManager.onRestoreInstanceState(state)
            } ?: run {
                notifyItemRangeInserted(index, data.size)
            }
        } else {
            list.add(index, data)
            recyclerViewSoft?.get()?.apply {
                val state = this.layoutManager.onSaveInstanceState()
                notifyItemInserted(index)
                this.layoutManager.onRestoreInstanceState(state)
            } ?: run {
                notifyItemInserted(index)
            }
        }
    }

    override fun getData(position: Int): Any = list[position]

    override fun removeAllData() {
        if (list.isNotEmpty()) {
            list.clear()
            notifyDataSetChanged()
        }
    }

    override fun removeAllNotRefresh() {
        list.clear()
    }

    override fun removeData(data: Any) {
        val contains = list.contains(data)
        if (contains) {
            val index = list.indexOf(data)
            removeData(index)
        }
    }

    override fun removeData(position: Int) {
        if (list.size == 0) {
            return
        }
        if (position >= 0 && position <= list.size - 1) {
            list.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    override fun removeDataFromIndex(index: Int) {
        val count = list.size
        list.subList(index, list.size).clear()
        notifyItemRangeRemoved(index, count)
    }

    override fun replaceData(position: Int, data: Any) {
        list.removeAt(position)
        list.add(position, data)
        notifyItemChanged(position)
    }

    private fun restoreRecyclerView() {
        recyclerViewSoft?.get()?.apply {
            val state = this.layoutManager.onSaveInstanceState()
            this.layoutManager.onRestoreInstanceState(state)
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        val any = list[position]
        return attachViewTypeLayout(any)
    }

    override fun onViewAttachedToWindow(holder: MoreViewHolder<Any>) {
        super.onViewAttachedToWindow(holder)
//        Log.d(TAG, "MoreAdapter onViewAttachedToWindow  ${holder.javaClass.simpleName} ")
        addAnimation(holder)
        visibleHolders?.let {
//            Log.d(TAG, "MoreAdapter onViewAttachedToWindow  ${holder.javaClass.simpleName}---scrollUp= $scrollUp ${it.contains(holder)}")
            if (!it.contains(holder)) {
                it.add(holder)
                holder.onViewAttachedToWindow()
            }
        }
    }

    override fun onViewDetachedFromWindow(holder: MoreViewHolder<Any>) {
        super.onViewDetachedFromWindow(holder)
//        Log.d(TAG, "MoreAdapter onViewDetachedFromWindow  ${holder.javaClass.simpleName} ")
        visibleHolders?.let {
//            Log.d(TAG, "MoreAdapter onViewAttachedToWindow  ${holder.javaClass.simpleName} scrollUp= $scrollUp $it")
            it.remove(holder)
            holder.onViewDetachedFromWindow()
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
//        Log.d(TAG, "MoreAdapter onWindowFocusChanged ")
        getVisibleHolders()?.let {
//            Log.d(TAG, "MoreAdapter onWindowFocusChanged scrollUp= $scrollUp $it")
            for (i in it.indices) {
                it[i].onWindowFocusChanged(hasFocus)
            }
        }
    }

    override fun onPauseResume(onResume: Boolean) {
//        Log.d(TAG, "MoreAdapter onPauseResume ")
        getVisibleHolders()?.let {
//            Log.d(TAG, "MoreAdapter onPauseResume $onResume scrollUp= $scrollUp ---$it")
            for (i in it.indices) {
                it[i].onPauseResume(onResume)
            }
        }
    }

    override fun onHolderScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        if (dy != 0 && direction){
            scrollUp = dy > 0
        }
//        Log.d(TAG, "MoreAdapter onHolderScrolled dy $dy")
        getVisibleHolders()?.let {
//            Log.d(TAG, "MoreAdapter onHolderScrolled visibleHolders scrollUp= $scrollUp $it")
            for (i in it.indices) {
                it[i].onScrolled(recyclerView, dx, dy)
            }
        }
    }


    override fun onHolderScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//        Log.d(TAG, "MoreAdapter onHolderScrollStateChanged ")
        getVisibleHolders()?.let {
//            Log.d(TAG, "MoreAdapter onHolderScrollStateChanged scrollUp= $scrollUp $it")
            for (i in it.indices) {
                it[i].onScrollStateChanged(recyclerView, newState)
            }
        }
    }

    /** [scrollMonitor] open scroll monitor */
    override fun scrollMonitor(monitor: Boolean, direction: Boolean): MoreAdapter {
        if (monitor) {
            visibleHolders = arrayListOf()
            this.direction = direction
        }
        return this
    }

    fun getVisibleHolders(reverse: Boolean = true): MutableList<IViewHolderScrollMonitor>? {
        if (visibleHolders == null || scrollUp || !reverse){
            return visibleHolders
        }
        return visibleHolders!!.asReversed()
    }

    /** [renderWithAnimation] user default animation AlphaAnimation */
    override fun renderWithAnimation(): MoreAdapter {
        this.animation = AlphaAnimation()
        return this
    }

    /** [renderWithAnimation] user custom animation */
    override fun renderWithAnimation(animation: MoreAnimation): MoreAdapter {
        this.animation = animation
        return this
    }

    /** [addAnimation] addAnimation when view attached to windows */
    override fun addAnimation(holder: MoreViewHolder<Any>) {
        this.animation?.let {
            if (holder.layoutPosition < startAnimPosition) {
                return
            }
            if (!firstShow || holder.layoutPosition > lastAnimPosition) {
                val animators = it.getItemAnimators(holder.itemView)
                for (anim in animators) {
                    anim.setDuration(animDuration).start()
                    anim.interpolator = linearInterpolator
                }
                lastAnimPosition = holder.layoutPosition
            }
        }
    }

    /** [duration] set animation duration */
    override fun duration(duration: Long): MoreAdapter {
        this.animDuration = duration
        return this
    }

    /** [firstShowAnim] set isShow animation when first display  */
    override fun firstShowAnim(firstShow: Boolean): MoreAdapter {
        this.firstShow = firstShow
        return this
    }

    /** [startAnimPosition] set animation start position */
    override fun startAnimPosition(position: Int): MoreAdapter {
        this.startAnimPosition = position
        return this
    }

    /** [register] register viewType which single link with model  */
    override fun register(registerItem: RegisterItem) {
        linkManager.register(registerItem)
    }

    override fun register(clazz: Class<out MoreViewHolder<*>>, clickListener: MoreClickListener?) {
        linkManager.register(clazz, clickListener)
    }

    /** [multiRegister] multiRegister viewType like one2more case , user MultiLink to choose which one is we need */
    override fun multiRegister(link: MultiLink<*>) {
        linkManager.multiRegister(link)
    }

    /** [attachViewTypeLayout]  find viewType layout by item of list */
    override fun attachViewTypeLayout(any: Any): Int = linkManager.attachViewTypeLayout(any)

    /** [createViewHolder]  find viewType by layout */
    override fun createViewHolder(type: Int): Class<out MoreViewHolder<*>> = linkManager.createViewHolder(type)

    override fun bindClickListener(holder: MoreViewHolder<*>): MoreClickListener? = linkManager.bindClickListener(holder)

    /** [userSoleRegister] register sole global viewType */
    override fun userSoleRegister() = linkManager.userSoleRegister()
}