# MoreType

> new method to build data in RecyclerView with Kotlin!

<a href="https://fir.im/k9yq"><img src="https://raw.githubusercontent.com/Werb/MoreType/master/app/src/main/res/mipmap-xhdpi/app_icon.png" width = "90" alt="download" align=center /></a>

Click icon download lastest sample

[English](https://github.com/Werb/MoreType/blob/master/README_EN.md) | [中文版](https://github.com/Werb/MoreType/blob/master/README_ZH.md)

[![Build Status](https://travis-ci.org/Werb/MoreType.svg?branch=master)](https://travis-ci.org/Werb/MoreType)
[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg)](https://github.com/Werb/MoreType/blob/master/LICENSE)
 [ ![Download](https://api.bintray.com/packages/werbhelius/maven/moretype/images/download.svg) ](https://bintray.com/werbhelius/maven/moretype/_latestVersion)
 [![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=16)

关键词:【数据驱动视图】

之前在写公司的项目的时候，需要写大量的界面，这就意味着每一个界面都要写一个 Adapter，同时还要对不同的视图根据 getItemViewHolder() 写不同的 ViewHolder，在存在多种视图的时候，一个 Adapter 中的代码就会很冗余，而且耦合度很高，对后续的修改很不友好。

**我们任意一个界面都是依靠服务器返回的数据构建的，所以我就在想，能不能简单的使用数据来驱动视图，这就也是 MoreType 的核心所在【数据驱动视图】。**

我并不是第一个想到这个概念的人，我最早看到这个概念的实践，是 drakeet 的 [MultiType](https://github.com/drakeet/MultiType) 。当时看完他的项目之后，有一种醍醐灌顶的畅快，这就是我所希望的【数据驱动视图】。

大概在一个月前，开始接触 Kotlin，Kotlin 是一个让开发者用起来很爽的语言，不必深陷烦人的空指针异常，简洁的代码风格，在初次尝时候我就喜欢上了它，所以我决定用 Kotlin 来开发一个【数据驱动视图】的第三方库，从而就有了 MoreType 的产生【给你更多的可能】。

[与 MultiType 的异同](https://github.com/Werb/MoreType/issues/1)

## Preview
![more-type-one](./screenshot/type1.png)
![more-type-two](./screenshot/type2.png)

## Dependency
```gradle
compile 'com.werb.moretype:moretype:0.3.1'
```
or
```gradle
implementation 'com.werb.moretype:moretype:0.3.1'
```

## Usage

Keyword: 【数据驱动视图】

#### Step 1. 创建一个数据模型类，例如:
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

### Step 2. 创建一个类 xxxViewHolder 继承抽象类 `MoreViewHolder<T : Any>()` 例如:

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

* 相比 0.1.8 版本移除了 `MoreViewType` 使用 `MoreViewHolder` 替代，回归 `RecyclerView` 绑定数据最初的方式
* 仅仅需要实现泛型确定相对应的数据类即可，关于布局的引入提前到了注册的部分，可以更加灵活的构建列表
* Android studio 3.0 版本自动依赖了 `kotlin-android-extensions`，同时 `kotlin1.1.4-3` 集成了 `LayoutContainer`，在 `ViewHolder` 中使用 `View` 可以直接通过 `id` 使用，如上代码所示，更加简洁
* **但需要注意的是，如果采用这样的方式，那么就意味着 `Layout` 已经确定，请确保在注册时声明的 `Layout` 和 `ViewHolder` 中 `Layout` 的一致性**

### Step 3. 在使用 `RecyclerView` 的地方，声明 `MoreAdapter()`对象，`register` 需要的 `ViewHolder`，同时和 `RecyclerView` 绑定

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
* 0.2.0 版本引入了 `RegisterItem`，在 0.2.0 版本中一切注册（包括 one2more ）都以 `RegisterItem` 为基本模型
```kotlin
data class RegisterItem(val layoutId: Int, val clazzViewHolder: Class<out MoreViewHolder<*>>, var clickListener: MoreClickListener? = null)
```
* 三个参数分别是 **Layout（布局）** ， **clazzViewHolder（ViewHolder 类）**， **clickListener（点击事件）**
* 点击事件为可选参数
* 0.2.3 版本引入了 `@LayoutID( val layoutID: Int )` 在单一模型注册绑定的时候，你可以使用此方法

完成这三步，一个根据【数据驱动视图】的列表就已经构建完成。


## Feature
### Multi Register: Register one2more ViewHolder

通常我们的数据和视图是一对一的关系，比如瀑布流。MoreType 同时提供一种数据类型对应多种视图的情况，例如私信界面。

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

提供五种动画支持: **Alpha** , **Scale** , **SlideInBottom** , **SlideInLeft** , **SlideInRight**

```Kotlin
    adapter.register(TitleViewHolder())
            .register(AnimViewHolder())
            /* assign Animation */
            .renderWithAnimation(AlphaAnimation())
            /* set Animation start position in list */
            .startAnimPosition(1)
            /* set is always show animation or show in first display */
            .firstShowAnim(true)
            .attachTo(anim_list)
```

同时支持自定义动画, 创建一个类实现接口 `MoreAnimation` and 重写 `getItemAnimators(view: View)` 例如:
```kotlin
class SlideInLeftAnimation : MoreAnimation {

    override fun getItemAnimators(view: View): Array<Animator>{
        return arrayOf(ObjectAnimator.ofFloat(view, "translationX", -view.rootView.width.toFloat(), 0f))
    }

}
```

### ItemClick: Support onItemClick and onItemLongClick

两种方式实现点击事件: **In ViewHolder** and **In Activity**

**In ViewHolder 中处理点击事件** : 在ViewHolder中使用 `view.setOnClickListener {}` 

**In Activity 中处理点击事件** :
1. 在 ViewHolder 中使用 `addOnClickListener(view: View)` or `addOnClickListener(viewId: Int)` 绑定点击事件
2. 在 Activity 中通过 `MoreClickListener()` 创建点击事件对象，在注册的时候传入即可

[sample](https://github.com/Werb/MoreType/tree/master/app/src/main/java/com/werb/moretype/click)

### Refresh and loadMore
**Refresh**: 使用 `SwipeRefreshLayout` 就可以实现下拉刷新

**LoadMore**: 通过构建 `Footer.class` 和 `FootViewHolder` 实现数据和视图的绑定, 当 RecyclerView 滚动在底部时显示 `FootViewHolder`，在数据请求成功后移除 `FootViewHolder`

[sample](https://github.com/Werb/MoreType/blob/master/app/src/main/java/com/werb/moretype/complete/CompleteActivity.kt)

### 全局 ViewHolder
**在自定义 Application中注册全局 ViewHolder**
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

通过 `adapter.userSoleRegister()` 调用使用全局 ViewHolder

## Thanks
[MultiType](https://github.com/drakeet/MultiType)

[recyclerview-animators](https://github.com/wasabeef/recyclerview-animators)

## LICENSE
[Apache License](./LICENSE)



