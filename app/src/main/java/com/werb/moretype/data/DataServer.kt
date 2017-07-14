package com.werb.moretype.data

import com.werb.moretype.MyApp
import com.werb.moretype.R
import com.werb.moretype.main.MainCard
import com.werb.moretype.multi.Message
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

    fun getMultiRegisterData() : List<Any> {
        val multiRegisterList = arrayListOf<Any>()
        multiRegisterList.add(MainCard("Multi Register", "Register one2more ViewType"))
        multiRegisterList.add(Message(
                "https://avatars5.githubusercontent.com/u/12763277?v=4&s=460",
                "text",
                false,
                "Hello, i am wanbo",
                "",
                "1500048339",
                "",
                "",
                true
        ))
        multiRegisterList.add(Message(
                "",
                "text",
                true,
                "Hello, this is MoreType, new method to build data in RecyclerView with Kotlin!",
                "",
                "1500048446",
                "",
                "",
                false
        ))
        multiRegisterList.add(Message(
                "https://avatars5.githubusercontent.com/u/12763277?v=4&s=460",
                "image",
                false,
                "",
                "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9",
                "1500049048",
                "467",
                "292",
                true
        ))
        multiRegisterList.add(Message(
                "",
                "text",
                true,
                "Wow, so cool, i like it",
                "",
                "1500049067",
                "",
                "",
                false
        ))
        multiRegisterList.add(Message(
                "",
                "image",
                true,
                "",
                "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782",
                "1500049067",
                "3794",
                "2133",
                false
        ))
        return multiRegisterList
    }

}