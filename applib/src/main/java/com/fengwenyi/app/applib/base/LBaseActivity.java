package com.fengwenyi.app.applib.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.fengwenyi.app.applib.tool.AppManager;
import com.fengwenyi.app.applib.tool.ToastUtil;

/**
 * Library Base Activity
 * @author Wenyi Feng
 */

public abstract class LBaseActivity extends AppCompatActivity {

    public Context mContext;
    public Activity mActivity;

    // Init
    public abstract void init ();

    // Layout
    public abstract Integer getLayout ();

    // Click Events
    public abstract void click ();


    /**
     * Toast
     * @param msg
     */
    public void toast (String msg) {
        ToastUtil.show(this, msg);
    }

    private Long lastClickTime = 0L;

    // 是否快速点击
    private Boolean isFastClick () {
        Boolean result = true;
        Long currClickTime = System.currentTimeMillis();
        if (currClickTime - lastClickTime > 1000) result = false;
        lastClickTime = currClickTime;
        return result;
    }

    // 点击事件
    private void onClick () {
        if (!isFastClick()) {
            click();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayout());

        mContext = this;
        mActivity = this;

        AppManager.newInstance().addActivity(this);

        init();

        onClick();
    }
}
