# MoreType

> new method to build data in RecyclerView with Kotlin!

<a href="https://fir.im/k9yq"><img src="https://raw.githubusercontent.com/Werb/MoreType/master/app/src/main/res/mipmap-xhdpi/app_icon.png" width = "90" alt="download" align=center /></a>

Click icon download lastest sample

English | [中文版](https://github.com/Werb/MoreType/blob/master/README_ZH.md)

[![Build Status](https://travis-ci.org/werbhelius/MoreType.svg?branch=master)](https://travis-ci.org/werbhelius/MoreType)
[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg)](https://github.com/Werb/MoreType/blob/master/LICENSE)
 [ ![Download](https://api.bintray.com/packages/werbhelius/maven/moretype/images/download.svg) ](https://bintray.com/werbhelius/maven/moretype/_latestVersion)
 [![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=16)

Keyword: Data driven view 【数据驱动视图】

Before writing a project in the company, we need to write a large number of recyclerViews to display data, which means that each recyclerView must write an Adapter, but also for different views according to getItemViewType () write different ViewHolder, in the presence of multiple views Time, an adapter in the code will be very redundant, And the coupling is very high, the follow-up changes are very friendly. 

**Any of our recyclerViews are based on the data returned by the server to build, so I was wondering, can not simply use the data to drive the view, which is the core of the MoreType 【data driven view】.**

I am not The first thought of this concept, I first saw the concept of practice, is [drakeet's MultiType](https://github.com/drakeet/MultiType). After watching his project, i know this is what I hope [Data driven view]. 

**Kotlin on Android Now official.** Don't have to worry about the NullPointerException, simple code style, in the first time I like to like it, so I decided to use Kotlin to develop a **【data-driven view】** third-party library  of the , this was MoreType **【Give you more likely】**.

## Preview
![more-type-one](./screenshot/type1.png)
![more-type-two](./screenshot/type2.png)

## Dependency
```gradle
compile 'com.werb.moretype:moretype:$last_version'
```
or
```gradle
implementation 'com.werb.moretype:moretype:$last_version'
```

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
class SingleTypeOneViewHolder(values: MutableMap<String, Any>, containerView: View) : MoreViewHolder<SingleText>(containerView) {

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

## Feature
### Multi Register: Register one2more ViewHolder

Usually data and view are one-to-one relationships, like Feeds list, MoreType alse provide Multi Register like IM list, one data to Many views, MoreType can do it easily.

```kotlin
adapter.apply {
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
```
### Animation: Provides five types of Animation

Provide 5 animations: **Alpha** , **Scale** , **SlideInBottom** , **SlideInLeft** , **SlideInRight**

```Kotlin
    adapter.register(TitleViewType())
            .register(AnimViewType())
            /* assign Animation */
            .renderWithAnimation(AlphaAnimation())
            /* set Animation start position in list */
            .startAnimPosition(1)
            /* set is always show animation or show in first display */
            .firstShowAnim(true)
            .attachTo(anim_list)
```

Also suppost custom Animation, create a class implement `MoreAnimation` and override `getItemAnimators(view: View)` , like:
```kotlin
class SlideInLeftAnimation : MoreAnimation {

    override fun getItemAnimators(view: View): Array<Animator>{
        return arrayOf(ObjectAnimator.ofFloat(view, "translationX", -view.rootView.width.toFloat(), 0f))
    }

}
```

### ItemClick: Support onItemClick and onItemLongClick

Two ways to achieve ItemClick: **In ViewHolder** and **In Activity**

**In ViewType** : Just use `view.setOnClickListener {}` in ViewType

**In Activity** : 
1. use `addOnClickListener(view: View)` or `addOnClickListener(viewId: Int)` to bind event in ViewType
2. In the Activity through the `MoreClickListener ()` to create a click event object, you can pass in the registration

[sample](https://github.com/Werb/MoreType/tree/master/app/src/main/java/com/werb/moretype/click)

### Refresh and loadMore
**Refresh**: use `SwipeRefreshLayout`

**LoadMore**: build `Footer.class` and `FootViewType` , when list smooth to last position - 1, show  `FootViewType` and remove `FootViewType`  when new data load successful

[sample](https://github.com/Werb/MoreType/blob/master/app/src/main/java/com/werb/moretype/complete/CompleteActivity.kt)

### Sole Global ViewType
**Register global viewType in Custom Application**
```kotlin
class MyApp: Application() {

   companion object {
       @Volatile lateinit var myApp: MyApp
           private set
   }

    override fun onCreate() {
        super.onCreate()
        myApp = this
        // Sole Global Register, like footer , Cutting line
        MoreType.soleRegister(RegisterItem(R.layout.item_view_footer, FootViewHolder::class.java))
    }
}
```

and we can use it in any where with `adapter.userSoleRegister()`

### inject Value In ViewHolder
```kotlin
    adapter.apply {
        injectValueInAllHolder(mapOf("qqqqqq" to "1233333333")) // inject in All Holder
        register(MainCardViewHolder::class.java, playLoadClick, mapOf("someValue" to "123")) // inject in single holder
        attachTo(more_list)
    }
```

## Thanks
[MultiType](https://github.com/drakeet/MultiType)

[recyclerview-animators](https://github.com/wasabeef/recyclerview-animators)

## LICENSE
[Apache License](./LICENSE)



