package com.fengwenyi.app.simple.tool;

import android.content.Context;

import com.fengwenyi.app.applib.dialog.LoadingDialog;

/**
 * @author Wenyi Feng
 */

public class Utils {

    public static void loading (Context context) {
        LoadingDialog.Builder loadBuilder = new LoadingDialog.Builder(context);
        loadBuilder.create().show();
    }

    public static void loadingMore (Context context) {
        LoadingDialog.Builder loadBuilder = new LoadingDialog.Builder(context)
                .setShowMsg(true)
                .setMsg("Loading")
                .setCancelOutside(true)
                .setCancelable(true);
        loadBuilder.create().show();
    }
}
