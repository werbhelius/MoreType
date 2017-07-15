package com.werb.moretype.data

import com.werb.moretype.MyApp
import com.werb.moretype.R
import com.werb.moretype.anim.AnimType
import com.werb.moretype.click.ItemClick
import com.werb.moretype.complete.Complete
import com.werb.moretype.main.MainCard
import com.werb.moretype.me.MeInfo
import com.werb.moretype.me.MeMessage
import com.werb.moretype.me.MeThanks
import com.werb.moretype.multi.Message
import com.werb.moretype.single.SingleImage
import com.werb.moretype.single.SingleText

/**
 * Created by wanbo on 2017/7/14.
 */
object DataServer {

    fun getMainCardData(): List<MainCard> {
        val mainCardList = arrayListOf<MainCard>()
        mainCardList.add(MainCard("Single Register", "Register one2one ViewType"))
        mainCardList.add(MainCard("Multi Register", "Register one2more ViewType"))
        mainCardList.add(MainCard("Animation", "Provides five types of Animation"))
        mainCardList.add(MainCard("ItemClick", "Support onItemClick and onItemLongClick"))
        mainCardList.add(MainCard("Complete Example", "A combination of elegant implementation layouts with refresh and loadMore"))
        mainCardList.add(MainCard("About Me", "Developer & Designer"))
        return mainCardList
    }

    fun getSingleRegisterData(): List<Any> {
        val singleRegisterList = arrayListOf<Any>()
        singleRegisterList.add(MainCard("Single Register", "Register one2one ViewType"))
        singleRegisterList.add(SingleText(MyApp.myApp.getString(R.string.app_name), MyApp.myApp.getString(R.string.app_desc), "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleText(MyApp.myApp.getString(R.string.app_name), MyApp.myApp.getString(R.string.app_desc), "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleText(MyApp.myApp.getString(R.string.app_name), MyApp.myApp.getString(R.string.app_desc), "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleText(MyApp.myApp.getString(R.string.app_name), MyApp.myApp.getString(R.string.app_desc), "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleText(MyApp.myApp.getString(R.string.app_name), MyApp.myApp.getString(R.string.app_desc), "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleText(MyApp.myApp.getString(R.string.app_name), MyApp.myApp.getString(R.string.app_desc), "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        singleRegisterList.add(SingleImage(MyApp.myApp.getString(R.string.app_name), "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9"))
        return singleRegisterList
    }

    fun getMultiRegisterData(): List<Any> {
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

    fun getAnimData(): List<Any> {
        val animDataList = arrayListOf<Any>()
        animDataList.add(MainCard("Animation", "Provides five types of Animation"))
        animDataList.add(AnimType("看图：这里是过去24小时发生的重要的事", "城市", "http://img.qdaily.com/category/icon_yellow_app/20160606004533uFozK3xI4CHZjfSM.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170715103111KHrZm3894Ys7uGIB.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("盗版碟商贩，本周的时代预言家 | 好奇心辞典", "城市", "http://img.qdaily.com/category/icon_yellow_app/20160606004533uFozK3xI4CHZjfSM.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170714180204gKehPAICiFdx1Uwm.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("这部纪录片美极了，而且居然没有用到特效", "娱乐", "http://img.qdaily.com/category/icon_yellow_app/20160606004531TgJK5XPy61qfS7rN.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170712164259UN4sqz2rogl0bWKY.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("诺兰表示，《敦刻尔克》的叙事结构可能是他所有作品中最复杂的。？", "娱乐", "http://img.qdaily.com/category/icon_yellow_app/20160606004531TgJK5XPy61qfS7rN.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170714133142RYHh7qjSKcUPa9wp.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("看图：这里是过去24小时发生的重要的事", "城市", "http://img.qdaily.com/category/icon_yellow_app/20160606004533uFozK3xI4CHZjfSM.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170715103111KHrZm3894Ys7uGIB.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("盗版碟商贩，本周的时代预言家 | 好奇心辞典", "城市", "http://img.qdaily.com/category/icon_yellow_app/20160606004533uFozK3xI4CHZjfSM.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170714180204gKehPAICiFdx1Uwm.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("这部纪录片美极了，而且居然没有用到特效", "娱乐", "http://img.qdaily.com/category/icon_yellow_app/20160606004531TgJK5XPy61qfS7rN.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170712164259UN4sqz2rogl0bWKY.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("诺兰表示，《敦刻尔克》的叙事结构可能是他所有作品中最复杂的。？", "娱乐", "http://img.qdaily.com/category/icon_yellow_app/20160606004531TgJK5XPy61qfS7rN.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170714133142RYHh7qjSKcUPa9wp.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("看图：这里是过去24小时发生的重要的事", "城市", "http://img.qdaily.com/category/icon_yellow_app/20160606004533uFozK3xI4CHZjfSM.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170715103111KHrZm3894Ys7uGIB.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("盗版碟商贩，本周的时代预言家 | 好奇心辞典", "城市", "http://img.qdaily.com/category/icon_yellow_app/20160606004533uFozK3xI4CHZjfSM.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170714180204gKehPAICiFdx1Uwm.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("这部纪录片美极了，而且居然没有用到特效", "娱乐", "http://img.qdaily.com/category/icon_yellow_app/20160606004531TgJK5XPy61qfS7rN.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170712164259UN4sqz2rogl0bWKY.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("诺兰表示，《敦刻尔克》的叙事结构可能是他所有作品中最复杂的。？", "娱乐", "http://img.qdaily.com/category/icon_yellow_app/20160606004531TgJK5XPy61qfS7rN.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170714133142RYHh7qjSKcUPa9wp.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("看图：这里是过去24小时发生的重要的事", "城市", "http://img.qdaily.com/category/icon_yellow_app/20160606004533uFozK3xI4CHZjfSM.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170715103111KHrZm3894Ys7uGIB.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("盗版碟商贩，本周的时代预言家 | 好奇心辞典", "城市", "http://img.qdaily.com/category/icon_yellow_app/20160606004533uFozK3xI4CHZjfSM.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170714180204gKehPAICiFdx1Uwm.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("这部纪录片美极了，而且居然没有用到特效", "娱乐", "http://img.qdaily.com/category/icon_yellow_app/20160606004531TgJK5XPy61qfS7rN.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170712164259UN4sqz2rogl0bWKY.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("诺兰表示，《敦刻尔克》的叙事结构可能是他所有作品中最复杂的。？", "娱乐", "http://img.qdaily.com/category/icon_yellow_app/20160606004531TgJK5XPy61qfS7rN.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170714133142RYHh7qjSKcUPa9wp.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("看图：这里是过去24小时发生的重要的事", "城市", "http://img.qdaily.com/category/icon_yellow_app/20160606004533uFozK3xI4CHZjfSM.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170715103111KHrZm3894Ys7uGIB.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("盗版碟商贩，本周的时代预言家 | 好奇心辞典", "城市", "http://img.qdaily.com/category/icon_yellow_app/20160606004533uFozK3xI4CHZjfSM.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170714180204gKehPAICiFdx1Uwm.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("这部纪录片美极了，而且居然没有用到特效", "娱乐", "http://img.qdaily.com/category/icon_yellow_app/20160606004531TgJK5XPy61qfS7rN.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170712164259UN4sqz2rogl0bWKY.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("诺兰表示，《敦刻尔克》的叙事结构可能是他所有作品中最复杂的。？", "娱乐", "http://img.qdaily.com/category/icon_yellow_app/20160606004531TgJK5XPy61qfS7rN.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170714133142RYHh7qjSKcUPa9wp.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("看图：这里是过去24小时发生的重要的事", "城市", "http://img.qdaily.com/category/icon_yellow_app/20160606004533uFozK3xI4CHZjfSM.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170715103111KHrZm3894Ys7uGIB.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("盗版碟商贩，本周的时代预言家 | 好奇心辞典", "城市", "http://img.qdaily.com/category/icon_yellow_app/20160606004533uFozK3xI4CHZjfSM.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170714180204gKehPAICiFdx1Uwm.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("这部纪录片美极了，而且居然没有用到特效", "娱乐", "http://img.qdaily.com/category/icon_yellow_app/20160606004531TgJK5XPy61qfS7rN.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170712164259UN4sqz2rogl0bWKY.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        animDataList.add(AnimType("诺兰表示，《敦刻尔克》的叙事结构可能是他所有作品中最复杂的。？", "娱乐", "http://img.qdaily.com/category/icon_yellow_app/20160606004531TgJK5XPy61qfS7rN.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1",
                "http://img.qdaily.com/article/article_show/20170714133142RYHh7qjSKcUPa9wp.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1"))
        return animDataList
    }

    fun getItemClickData(): List<Any> {
        val itemClickDataList = arrayListOf<Any>()
        itemClickDataList.add(MainCard("ItemClick", "Support onItemClick and onItemLongClick"))
        itemClickDataList.add(ItemClick("MoreType ItemClick", "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782", true))
        itemClickDataList.add(ItemClick("MoreType ItemClick", "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9", false))
        itemClickDataList.add(ItemClick("MoreType ItemClick", "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782", true))
        itemClickDataList.add(ItemClick("MoreType ItemClick", "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9", false))
        itemClickDataList.add(ItemClick("MoreType ItemClick", "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782", true))
        itemClickDataList.add(ItemClick("MoreType ItemClick", "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9", false))
        itemClickDataList.add(ItemClick("MoreType ItemClick", "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782", true))
        itemClickDataList.add(ItemClick("MoreType ItemClick", "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9", false))
        itemClickDataList.add(ItemClick("MoreType ItemClick", "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782", true))
        itemClickDataList.add(ItemClick("MoreType ItemClick", "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9", false))
        itemClickDataList.add(ItemClick("MoreType ItemClick", "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782", true))
        itemClickDataList.add(ItemClick("MoreType ItemClick", "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9", false))
        itemClickDataList.add(ItemClick("MoreType ItemClick", "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782", true))
        itemClickDataList.add(ItemClick("MoreType ItemClick", "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9", false))
        itemClickDataList.add(ItemClick("MoreType ItemClick", "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782", true))
        itemClickDataList.add(ItemClick("MoreType ItemClick", "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9", false))
        return itemClickDataList
    }

    fun getCompleteData(): List<Any> {
        val completeDataList = arrayListOf<Any>()
        completeDataList.add(Complete(
                "wanbo",
                "Developer & Designer",
                "http://wx3.sinaimg.cn/mw690/b447c185ly8fdocwsavc6j20ku0kuaba.jpg",
                "1500106878",
                "new method to build data in RecyclerView with Kotlin!",
                "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782",
                "467",
                "292"
        ))
        completeDataList.add(Complete(
                "wanbo",
                "Curiosity",
                "http://wx3.sinaimg.cn/mw690/b447c185ly8fdocwsavc6j20ku0kuaba.jpg",
                "1500107414",
                "The motivation that drives me to keep trying is my curiosity",
                "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9",
                "467",
                "292"
        ))
        completeDataList.add(Complete(
                "wanbo",
                "I'm actually a musician",
                "http://wx3.sinaimg.cn/mw690/b447c185ly8fdocwsavc6j20ku0kuaba.jpg",
                "1500108765",
                "Can you read this paragraph? My dream is to make music. My idol is jay Chou. I want to stand on the stage like him and sing for my favorite people",
                "http://h.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=e778191ebd3eb1354492bfbf932e84e5/9213b07eca8065386ba591e596dda144ac3482fc.jpg",
                "436",
                "600"
        ))
        completeDataList.add(Complete(
                "wanbo",
                "Try all kinds of things",
                "http://wx3.sinaimg.cn/mw690/b447c185ly8fdocwsavc6j20ku0kuaba.jpg",
                "1500107762",
                "Pixel-Web ，It was my first Vue project",
                "https://raw.githubusercontent.com/Werb/Pixel-Web/master/screenshots/pixel-web-one.png",
                "1890",
                "850"
        ))
        completeDataList.add(Complete(
                "wanbo",
                "Android Developer",
                "http://wx3.sinaimg.cn/mw690/b447c185ly8fdocwsavc6j20ku0kuaba.jpg",
                "1500107779",
                "Forgot when I started liking Android",
                "http://img0.imgtn.bdimg.com/it/u=4177297633,2800217385&fm=26&gp=0.jpg",
                "580",
                "358"
        ))
        completeDataList.add(Complete(
                "wanbo",
                "Developer & Designer",
                "http://wx3.sinaimg.cn/mw690/b447c185ly8fdocwsavc6j20ku0kuaba.jpg",
                "1500106878",
                "new method to build data in RecyclerView with Kotlin!",
                "https://boygeniusreport.files.wordpress.com/2014/12/ultimate-material-lollipop-collection-268.png?w=782",
                "467",
                "292"
        ))
        completeDataList.add(Complete(
                "wanbo",
                "Curiosity",
                "http://wx3.sinaimg.cn/mw690/b447c185ly8fdocwsavc6j20ku0kuaba.jpg",
                "1500107414",
                "The motivation that drives me to keep trying is my curiosity",
                "https://img.scoop.it/f9ZSLthhGIc6nSw9gF7Z1Tl72eJkfbmt4t8yenImKBVvK0kTmF0xjctABnaLJIm9",
                "467",
                "292"
        ))
        completeDataList.add(Complete(
                "wanbo",
                "I'm actually a musician",
                "http://wx3.sinaimg.cn/mw690/b447c185ly8fdocwsavc6j20ku0kuaba.jpg",
                "1500108765",
                "Can you read this paragraph? My dream is to make music. My idol is jay Chou. I want to stand on the stage like him and sing for my favorite people",
                "http://h.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=e778191ebd3eb1354492bfbf932e84e5/9213b07eca8065386ba591e596dda144ac3482fc.jpg",
                "436",
                "600"
        ))
        completeDataList.add(Complete(
                "wanbo",
                "Try all kinds of things",
                "http://wx3.sinaimg.cn/mw690/b447c185ly8fdocwsavc6j20ku0kuaba.jpg",
                "1500107762",
                "Pixel-Web ，It was my first Vue project",
                "https://raw.githubusercontent.com/Werb/Pixel-Web/master/screenshots/pixel-web-one.png",
                "1890",
                "850"
        ))
        completeDataList.add(Complete(
                "wanbo",
                "Android Developer",
                "http://wx3.sinaimg.cn/mw690/b447c185ly8fdocwsavc6j20ku0kuaba.jpg",
                "1500107779",
                "Forgot when I started liking Android",
                "http://img0.imgtn.bdimg.com/it/u=4177297633,2800217385&fm=26&gp=0.jpg",
                "580",
                "358"
        ))
        return completeDataList
    }

    fun getAboutMeData(): List<Any> {
        val aboutMeDataList = arrayListOf<Any>()
        aboutMeDataList.add(MainCard("About Me", "Developer & Designer"))
        aboutMeDataList.add(MeInfo(
                "wanbo", "Developer & Designer", "http://wx3.sinaimg.cn/mw690/b447c185ly8fdocwsavc6j20ku0kuaba.jpg",
                "werbhelius@gmail.com", "https://github.com/Werb", "http://weibo.com/singerwannber "
        ))
        aboutMeDataList.add("设计初衷")
        aboutMeDataList.add(MeMessage(MyApp.myApp.getString(R.string.origin)))
        aboutMeDataList.add("MoreType 特性")
        aboutMeDataList.add(MeMessage(MyApp.myApp.getString(R.string.character)))
        aboutMeDataList.add("感谢")
        aboutMeDataList.add(MeThanks(
                "drakeet & MultiType",
                "在上学的时候，第一个关注的博客和 Github 就是 drakeet，他的项目无论是从代码结构还是设计模式上，都特别清晰，易懂，看完之后总有一种说不出的畅快，太棒了，一路跟着 drakeet 后面学习，感觉每一天都在飞速进步。",
                "http://ww4.sinaimg.cn/mw690/86e2ff85jw8esy5u72xzyg2050069jrv.gif",
                "https://github.com/drakeet/MultiType"
        ))
        aboutMeDataList.add(MeThanks(
                "wasabeef & recyclerview-animators",
                "MoreType 中对 Recyclerview 动画操作参考了这个非常棒的库，感谢开源的世界。",
                "https://raw.githubusercontent.com/wasabeef/recyclerview-animators/master/art/logo.jpg",
                "https://github.com/wasabeef/recyclerview-animators"
        ))
        aboutMeDataList.add("喜欢的一些话")
        aboutMeDataList.add(MeMessage(MyApp.myApp.getString(R.string.like_words_one)))
        aboutMeDataList.add(MeMessage(MyApp.myApp.getString(R.string.like_words_two)))
        return aboutMeDataList
    }
}