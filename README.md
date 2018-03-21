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
compile 'com.werb.moretype:moretype:0.2.5'
```
or
```gradle
implementation 'com.werb.moretype:moretype:0.2.5'
```

## Update log
#### [v0.2.5](https://github.com/Werb/MoreType/releases/tag/v0.2.5)
* fix fix payloads judge error
* update support lib version

## Usage

Keyword: Data driven view 【数据驱动视图】

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

### Step 2. create a class (xxxViewHolder) extends abstract class `MoreViewHolder<T : Any>()` , like:

```kotlin
// Register layoutID here or Register with adapter in Activity
@LayoutID(R.layout.item_view_single_type_one)
class SingleTypeOneViewHolder(containerView: View) : MoreViewHolder<SingleText>(containerView) {

    override fun bindData(data: SingleText, payloads: List<Any>) {
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

        /* register ViewHolder and attach to recyclerView */
        adapter.apply {
            // two method register Layout
            register(RegisterItem(R.layout.item_view_single_type_one, SingleTypeOneViewHolder::class.java))
            // or
            register(SingleTypeOneViewHolder::class.java)
            attachTo(single_register_list)
        }

        /* load any data List or model object */
        adapter.loadData(DataServer.getSingleRegisterData())

    }

}
```
Upon completion of these three steps, a list based on the [Data Driven View] has been completed.

