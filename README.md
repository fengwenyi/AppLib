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

## Other

[JavaLib](https://github.com/fengwenyi/JavaLib)：Java Library

[WebApp](https://github.com/fengwenyi/WebApp)：使用了 AppLib 中提供的 MVP 模式


## Author
```
	Wenyi Feng(xfsy_2015@163.com)
```