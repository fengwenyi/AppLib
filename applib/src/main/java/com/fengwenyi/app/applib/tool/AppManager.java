package com.fengwenyi.app.applib.tool;

import android.app.ActivityManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.util.Stack;

/**
 * Activity 管理工具类，用户管理 Activity
 * @author Wenyi Feng
 */

public class AppManager {

    // Activity 栈
    private static Stack<AppCompatActivity> activityStack;
    // 单例模式
    private static AppManager instance;

    private AppManager () {}

    // 单例实例
    public static AppManager newInstance () {
        if (instance == null) {
            instance = new AppManager();
        }
        return instance;
    }

    /**
     * 添加 Activity 到堆栈中
     * @param activity AppCompatActivity
     */
    public void addActivity (AppCompatActivity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    /**
     * 关闭指定的 Activity
     * @param activity AppCompatActivity
     */
    public void finishActivity (AppCompatActivity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * 结束指定类名的 Activity
     * @param cls 类名的 Activity
     */
    public void finishActivity (Class<?> cls) {
        for (AppCompatActivity activity : activityStack) {
            if (cls.equals(activity.getClass())) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 关闭所有 Activity
     */
    public void finishAllActivity () {
        for (AppCompatActivity activity : activityStack) {
            if (activity != null) {
                activity.finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 退出 App
     * @param context Context
     */
    public void appExit (Context context) {
        finishAllActivity();
        ActivityManager activityManager
                = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager != null) {
            activityManager.killBackgroundProcesses(context.getPackageName());
        }
        System.exit(0);
    }

}
