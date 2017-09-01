package com.werb.moretype

import android.support.multidex.MultiDexApplication
import com.facebook.drawee.backends.pipeline.Fresco
import com.werb.library.MoreType
import com.werb.moretype.complete.FootViewType

/**
 * Created by wanbo on 2017/7/12.
 */
class MyApp: MultiDexApplication() {

   companion object {
       @Volatile lateinit var myApp: MyApp
           private set
   }

    override fun onCreate() {
        super.onCreate()
        myApp = this
        Fresco.initialize(myApp)
        // Sole Global Register, like footer , Cutting line
        MoreType.soleRegister(FootViewType())
    }

}