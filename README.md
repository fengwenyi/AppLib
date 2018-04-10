# AppLib

Android Project Library

## Description

AppLib 全称 Android Project Library。

正如名字所说，AppLib帮助你快速构建MVP模式的Android Project，

因此你不需要再写AppManager，BaseXXX系列的代码文件。

## Function

* BaseXXX 系列

* 日期时间选择弹窗

* 模糊进度加载弹窗

* 值回调接口

* 常量

* 字体图标类

* 日志工具类

* Toast工具类

* 其他常用工具类

## Use

Step 1. Add the JitPack repository to your build file
	
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        // 关于版本号的问题，请直接咨询 author
	        compile 'com.github.fengwenyi:AppLib:1.0.1.7'
	}

## API

* MVP 模式

* 日期时间弹选择弹窗

* 模糊进度弹窗

* 值回调接口

* 字体图标

* Log

* Toast

## WiKi

1、mActivity 和 mContext

在 `LBaseActivity` 和 `LBaseFragment` 中都提供了 mActivity 和 mContext。
因此在你的 XxxActivity 或 XxxFragment 中，可以直接使用

2、字体图标

我原意是提供字体图标以便直接使用，但是并不要用，具体体现在以下几个方面：

* 提供的图标库里面有很多，要找很久，由于图标不全，结果是也找不到想要的
* 由于图标库改版，我也用不来

因此想着改变一下，但之前的库还是可以用的。

**教你快速使用字体图标**

你需要自定义View

```java
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * @author Wenyi Feng
 */

public class IconView extends AppCompatTextView {

    public IconView(Context context) {
        super(context);
        init(context);
    }
    public IconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    public IconView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context) {
//        设置字体图标
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"icon/iconfont.ttf"));
    }

}
```

之后，你需要去找图标库，我用的是 [阿里图标库](http://www.iconfont.cn/)

具体怎么做呢？大概分以下几步：

* 打开阿里图标库，登录并新建一个项目

* 首页搜索想要的图标，并加入购物车

* 将购物车中的图标添加到新建的项目中

* 去项目中勾选并加入到购物车中，点击购物车，下载（代码）

* 解压，将其中以 `.ttf` 结尾的文件拷贝

* 在 `main` 新建 assets 文件夹，再新建 icons 文件夹

* 粘贴到 icons 目录下

这样就可以使用了

```
    <com.fengwenyi.app.***.view.IconView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="&#xe67d;"
        android:textColor="#ffffff"
        android:textSize="20sp"/>
```

**AppLib中提供的字体图标**

// 这已经不重要了，抽空来吧


**这里有一个问题**

就是我们在xml中设置可以显示图标，但是在java代码中设置，却不能显示，
这该怎么解决呢？

请看下面代码：

```
    TextView icon = view.findViewById(R.id.tvIcon);
    icon.setText(Html.fromHtml(icons.get(position)));
```

[如果你在使用字体图标中遇到什么问题，欢迎与我交流]


## Other

[JavaLib](https://github.com/fengwenyi/JavaLib)：Java Library

[WebApp](https://github.com/fengwenyi/WebApp)：使用了 AppLib 中提供的 MVP 模式


## Author
```
	Wenyi Feng(xfsy_2015@163.com)
```