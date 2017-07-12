package com.werb.moretype

import android.app.Application
import com.werb.library.MoreType

/**
 * Created by wanbo on 2017/7/12.
 */
class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        MoreType.soleRegister(FooterViewType())
    }

}