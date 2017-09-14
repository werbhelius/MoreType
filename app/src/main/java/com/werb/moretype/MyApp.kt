package com.werb.moretype

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.github.moduth.blockcanary.BlockCanary
import com.werb.library.MoreType
import com.werb.library.link.RegisterItem
import com.werb.moretype.complete.FootViewHolder

/**
 * Created by wanbo on 2017/7/12.
 */
class MyApp: Application() {

   companion object {
       @Volatile lateinit var myApp: MyApp
           private set
   }

    override fun onCreate() {
        super.onCreate()
        myApp = this
        BlockCanary.install(this, AppContext()).start()
        Fresco.initialize(myApp)
        // Sole Global Register, like footer , Cutting line
        MoreType.soleRegister(RegisterItem(R.layout.item_view_footer, FootViewHolder::class.java))
    }

}