package com.fengwenyi.app.applib.base;

import android.app.Application;

/**
 * @author Wenyi Feng
 */

public class LBaseApplication extends Application {

    // Log debug 模式是否开启
    public Boolean isDebug = false;

    // 单一模式
    private static LBaseApplication APP;

    /**
     * 单一实例
     * @return LBaseApplication
     */
    public static LBaseApplication newInstance () {
        if (APP == null) {
            APP = new LBaseApplication();
        }
        return APP;
    }

}
