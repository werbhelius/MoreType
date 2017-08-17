package com.werb.moretype.multi

import android.Manifest
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.view.View
import com.werb.library.MoreAdapter
import com.werb.library.MoreViewType
import com.werb.library.link.MultiLink
import com.werb.moretype.R
import com.werb.moretype.TitleViewType
import com.werb.moretype.data.DataServer
import com.werb.permissionschecker.PermissionChecker
import com.werb.pickphotoview.PickPhotoView
import kotlinx.android.synthetic.main.activity_multi_register.*
import kotlinx.android.synthetic.main.widget_view_message_input.*
import com.werb.pickphotoview.util.PickConfig
import android.content.Intent
import com.werb.moretype.Utils


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
        permissionChecker?.setTitle(getString(R.string.check_info_title))
        permissionChecker?.setMessage(getString(R.string.check_info_message))

        toolbar.setNavigationIcon(R.mipmap.ic_close_white_24dp)
        toolbar.setNavigationOnClickListener { finish() }

        multi_register_list.layoutManager = LinearLayoutManager(this)
        adapter.register(TitleViewType())
                .multiRegister(Message::class, object : MultiLink<Message> {
                    override fun link(data: Message): MoreViewType<Message> {
                        return if (data.me) {
                            MessageOutViewType()
                        } else {
                            MessageInViewType()
                        }
                    }
                })
                .attachTo(multi_register_list)

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
            multi_register_list.smoothScrollToPosition(adapter.itemCount -1)
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
                .setStatusBarColor("#ffffff")
                .setToolbarColor("#ffffff")
                .setToolbarIconColor("#000000")
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

}