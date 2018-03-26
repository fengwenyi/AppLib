package com.fengwenyi.app.applib.tool;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast Util
 * @author Wenyi Feng
 */

public class ToastUtil {

    public static void show (Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}
