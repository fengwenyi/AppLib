package com.fengwenyi.app.applib.tool;

import android.util.Log;

import com.fengwenyi.app.applib.base.LBaseApplication;

/**
 * Log Util
 * @author Wenyi Feng
 */

public class LogUtil {

    /**
     * Log debug
     * @param msg Message String
     */
    public static void d (String msg) {
        if (LBaseApplication.newInstance().isDebug) {
            Log.d(Constanct.tagDebug, msg);
        }
    }

    /**
     * Log error
     * @param msg Message String
     */
    public static void e (String msg) {
        Log.e (Constanct.tagError, msg);
    }

}
