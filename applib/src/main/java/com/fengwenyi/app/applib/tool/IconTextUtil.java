package com.fengwenyi.app.applib.tool;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Text Icon Util
 * @author Wenyi Feng
 */

public class IconTextUtil {


    public static void injectFont (View rootView) {
        injectFont(rootView, getTypeface(rootView.getContext()));
    }

    /**
     * 注入图标
     * @param rootView View
     * @param tf Typeface
     */
    public static void injectFont (View rootView, Typeface tf) {
        if (rootView instanceof ViewGroup) {
            int count = ((ViewGroup) rootView).getChildCount();
            for (int i = 0; i < count; i++) {
                injectFont(((ViewGroup) rootView).getChildAt(i), tf);
            }
        } else if (rootView instanceof TextView) {
            ((TextView) rootView).setTypeface(tf);
        }
    }

    /**
     * 获取提供的字库图标库
     * @param context Context
     * @return Typeface
     */
    public static Typeface getTypeface (Context context) {
        return Typeface.createFromAsset(context.getAssets(), Constanct.fontAwesome);
    }

    /**
     * 自定义字体库
     * @param context Context
     * @param path 字体图标路径
     * @return Typeface
     */
    public static Typeface getTypeface (Context context, String path) {
        return Typeface.createFromAsset(context.getAssets(), path);
    }

}
