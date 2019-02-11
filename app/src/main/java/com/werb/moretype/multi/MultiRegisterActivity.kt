package com.werb.moretype.multi

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.werb.library.MoreAdapter
import com.werb.library.link.MultiLink
import com.werb.library.link.RegisterItem
import com.werb.moretype.R
import com.werb.moretype.TitleViewHolder
import com.werb.moretype.Utils
import com.werb.moretype.data.DataServer
import com.werb.permissionschecker.PermissionChecker
import com.werb.pickphotoview.PickPhotoView
import com.werb.pickphotoview.util.PickConfig
import kotlinx.android.synthetic.main.activity_multi_register.*
import kotlinx.android.synthetic.main.widget_view_message_input.*


/**
 * Created by wanbo on 2017/7/14.
 */
class MultiRegisterActivity : AppCompatActivity() {

    val PERMISSIONS = arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)
    private var permissionChecker: PermissionChecker? = null
    private val adapter = MoreAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_register)

        // permission check
        permissionChecker = PermissionChecker(this)

        toolbar.setNavigationIcon(R.mipmap.ic_close_white_24dp)
        toolbar.setNavigationOnClickListener { finish() }

        multi_register_list.layoutManager = LinearLayoutManager(this)
        adapter.apply {
            register(RegisterItem(R.layout.item_view_title, TitleViewHolder::class.java))
            multiRegister(object : MultiLink<Message>() {
                override fun link(data: Message): RegisterItem {
                    return if (data.me){
                        RegisterItem(R.layout.item_view_multi_message_out, MessageOutViewHolder::class.java)
                    }else {
                        RegisterItem(R.layout.item_view_multi_message_in, MessageInViewHolder::class.java)
                    }
                }
            })
            attachTo(multi_register_list)
        }

        adapter.loadData(DataServer.getMultiRegisterData())

        input_edit.setOnFocusChangeListener { view, hasFocus ->
            run {
                if (hasFocus) {
                    view.postDelayed({
                        multi_register_list.smoothScrollToPosition(adapter.itemCount -1)
                    }, 250)
                }
            }
        }

        layout_send.setOnClickListener(sendClick)
        input_image_layout.setOnClickListener(imageClick)
    }

    private val sendClick = View.OnClickListener {
        if (!TextUtils.isEmpty(input_edit.text.toString())) {
            adapter.loadData(buildSendMessageText())
            input_edit.setText("")
            multi_register_list.smoothScrollToPosition(adapter.itemCount)
            it.postDelayed({
                adapter.loadData(buildInMessageText())
                multi_register_list.smoothScrollToPosition(adapter.itemCount)
            }, 200)
        }
    }

    private val imageClick = View.OnClickListener {
        permissionChecker?.let {
            if (it.isLackPermissions(PERMISSIONS)) {
                it.requestPermissions()
            } else {
                pickPhoto()
            }
        }
    }

    private fun pickPhoto() {
        PickPhotoView.Builder(this@MultiRegisterActivity)
                .setPickPhotoSize(1)
                .setShowCamera(true)
                .setSpanCount(4)
                .setLightStatusBar(true)
                .setStatusBarColor(R.color.colorTextLight)
                .setToolbarColor(R.color.colorTextLight)
                .setToolbarTextColor(R.color.colorAccent)
                .setSelectIconColor(R.color.colorPrimary)
                .setShowGif(false)
                .start()
    }

    private fun buildSendMessageText(): Message {
        return Message(
                "",
                "text",
                true,
                input_edit.text.toString(),
                "",
                "",
                "",
                "",
                false
        )
    }

    private fun buildInMessageText(): Message {
        return Message(
                "https://avatars5.githubusercontent.com/u/12763277?v=4&s=460",
                "text",
                false,
                "收到你的消息",
                "",
                "",
                "",
                "",
                false
        )
    }

    private fun buildSendMessageImage(url: String, size: ImageSize): Message {
        return Message(
                "",
                "image",
                true,
                input_edit.text.toString(),
                url,
                "",
                size.width.toString(),
                size.height.toString(),
                false
        )
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        permissionChecker?.let {
            when (requestCode) {
                PermissionChecker.PERMISSION_REQUEST_CODE -> {
                    if (it.hasAllPermissionsGranted(grantResults)) {
                        pickPhoto()
                    }
                }
                else -> {
                    it.showDialog()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 0) {
            return
        }
        if (data == null) {
            return
        }
        if (requestCode == PickConfig.PICK_PHOTO_DATA) {
            val selectPaths = data.getSerializableExtra(PickConfig.INTENT_IMG_LIST_SELECT) as ArrayList<*>
            // do something u want
            val path = selectPaths[0] as String
            val imageSize = Utils.readImageSize(path)
            imageSize?.let {
                adapter.loadData(buildSendMessageImage(path, imageSize))
                multi_register_list.smoothScrollToPosition(adapter.itemCount)
            }
        }
    }

    companion object {
        fun startActivity(activity: Activity){
            activity.startActivity(Intent(activity, MultiRegisterActivity::class.java))
        }
    }

}