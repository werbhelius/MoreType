# MoreType

> new method to build data in RecyclerView with Kotlin!

<a href="https://fir.im/k9yq"><img src="https://raw.githubusercontent.com/Werb/MoreType/master/app/src/main/res/mipmap-xhdpi/app_icon.png" width = "90" alt="download" align=center /></a>

Click icon download lastest sample

[English](https://github.com/Werb/MoreType/blob/master/README_EN.md) | [中文版](https://github.com/Werb/MoreType/blob/master/README_ZH.md)

[![Build Status](https://travis-ci.org/Werb/MoreType.svg?branch=master)](https://travis-ci.org/Werb/MoreType)
[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg)](https://github.com/Werb/MoreType/blob/master/LICENSE)
 [ ![Download](https://api.bintray.com/packages/werbhelius/maven/moretype/images/download.svg) ](https://bintray.com/werbhelius/maven/moretype/_latestVersion)
 [![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=16)

 **Keyword: Data driven view 【数据驱动视图】**

 ## Preview
![more-type-one](./screenshot/type1.png)
![more-type-two](./screenshot/type2.png)

## Dependency
```gradle
compile 'com.werb.moretype:moretype:0.1.8'
compile "org.jetbrains.kotlin:kotlin-reflect:$kotlin_version"
```
or
```gradle
implementation 'com.werb.moretype:moretype:0.1.8'
implementation "org.jetbrains.kotlin:kotlin-reflect:$kotlin_version"
```

## Update log
#### [v0.1.8](https://github.com/Werb/MoreType/releases/tag/v0.1.8)
 remove Kclass in [MoreViewType.kt](https://github.com/Werb/MoreType/blob/master/library/src/main/java/com/werb/library/MoreViewType.kt#L13)

#### [v0.1.5-beta10](https://github.com/Werb/MoreType/releases/tag/v0.1.5-beta10)
1. add [initView()](https://github.com/Werb/MoreType/blob/master/library/src/main/java/com/werb/library/MoreViewType.kt#L17) method to reuse view in ViewType
2. add [findViewOfen()](https://github.com/Werb/MoreType/blob/master/library/src/main/java/com/werb/library/MoreViewHolder.kt#L56) in MoreViewHolder to cache and reuse view after first findViewById
3. add 8 [DataAction Method](https://github.com/Werb/MoreType/blob/master/library/src/main/java/com/werb/library/action/DataAction.kt) to operation data，like replace 、removeData、removeAllNotRefresh 

## Usage

#### Step 1. create a data model class, like:
```kotlin
data class SingleText(val title: String, val desc: String, val url: String)
```
or
```kotlin
class SingleText {
    var title: String? = null
    var desc: String? = null
    var url: String? = null
}
```

### Step 2. create a class (xxxViewType) extends abstract class `MoreViewType<T : Any>(layoutId, Class)` , like:

```kotlin
class SingleTypeOneViewType: MoreViewType<SingleText>(R.layout.item_view_single_type_one) {

    private lateinit var title: AppCompatTextView
    private lateinit var desc: AppCompatTextView
    private lateinit var icon: SimpleDraweeView

    override fun initView(holder: MoreViewHolder) {
        title = holder.findViewOften(R.id.title)
        desc = holder.findViewOften(R.id.desc)
        icon = holder.findViewOften(R.id.icon)

        // findViewOften() will cache and reuse view after first findViewBtId
    }

    override fun bindData(data: SingleText, holder: MoreViewHolder) {
        title.text = data.title
        desc.text = data.desc
        icon.setImageURI(data.url)
    }
}
```

### Step 3. `register` and `attach` to `recyclerview` in Any where you build list, like:

```kotlin
import kotlinx.android.synthetic.main.activity_single_register.*

class SingleRegisterActivity: AppCompatActivity() {

    private val adapter = MoreAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_register)

        list.layoutManager = LinearLayoutManager(this)

        /* register viewType and attach to recyclerView */
        adapter.register(TitleViewType())
                .register(SingleTypeOneViewType())
                .attachTo(list)

        /* load any data List or model object */
        adapter.loadData(DataServer.getSingleRegisterData())

    }

}
```
Upon completion of these three steps, a list based on the [Data Driven View] has been completed.

