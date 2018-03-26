package com.fengwenyi.app.applib.tool;

import android.content.Context;
import android.content.Intent;

/**
 * @author Wenyi Feng
 */

public class Utils {

    /**
     * 跳转
     * @param context Context
     * @param cls 类名
     */
    public static void intent (Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }

    public static String repair0 (int num) {
        String result = "00";
        if (num >= 0
                && num < 100) {
            if (num < 10) {
                result = "0" + num;
            } else {
                result = num + "";
            }
        }
        return result;
    }

}
