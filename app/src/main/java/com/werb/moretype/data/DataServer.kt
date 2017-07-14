package com.werb.moretype.data

import com.werb.moretype.MyApp
import com.werb.moretype.R
import com.werb.moretype.main.MainCard
import com.werb.moretype.single.SingleImage
import com.werb.moretype.single.SingleText

/**
 * Created by wanbo on 2017/7/14.
 */
object DataServer {

    fun getMainCardData(): List<MainCard>{
        val mainCardList = arrayListOf<MainCard>()
        mainCardList.add(MainCard("Single Register", "Register one2one ViewType"))
        mainCardList.add(MainCard("Multi Register", "Register one2more ViewType"))
        mainCardList.add(MainCard("Animation", "Provides five types of Animation"))
        mainCardList.add(MainCard("ItemClick", "Support onItemClick and onItemLongClick"))
        mainCardList.add(MainCard("Complete Example", "A combination of elegant implementation layouts"))
        mainCardList.add(MainCard("About Me", "Developer & Designer"))
        return mainCardList
    }

    fun getSingleRegisterData() : List<Any> {
        val singleRegisterList = arrayListOf<Any>()
        singleRegisterList.add(MainCard("Single Register", "Register one2one ViewType"))
        singleRegisterList.add(SingleText(MyApp.myApp.getString(R.string.app_name),MyApp.myApp.getString(R.string.app_desc), "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleText(MyApp.myApp.getString(R.string.app_name),MyApp.myApp.getString(R.string.app_desc), "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleText(MyApp.myApp.getString(R.string.app_name),MyApp.myApp.getString(R.string.app_desc), "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleText(MyApp.myApp.getString(R.string.app_name),MyApp.myApp.getString(R.string.app_desc), "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleText(MyApp.myApp.getString(R.string.app_name),MyApp.myApp.getString(R.string.app_desc), "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleText(MyApp.myApp.getString(R.string.app_name),MyApp.myApp.getString(R.string.app_desc), "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))

        return singleRegisterList
    }

}