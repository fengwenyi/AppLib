package com.fengwenyi.app.applib.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Library Base Fragment
 * @author Wenyi Feng
 */

public abstract class LBaseFragment<T extends LBasePresenter> extends Fragment {

    protected T presenter;

    private Long lastClickTime = 0L;

    public Context mContext;
    public Activity mActivity;

    // 是否快速点击
    private Boolean isFastClick () {
        Boolean result = true;
        Long currClickTime = System.currentTimeMillis();
        if (currClickTime - lastClickTime > 1000) result = false;
        lastClickTime = currClickTime;
        return result;
    }

    public abstract void init ();

    public abstract T initPresenter ();

    // Click Events
    public abstract void click ();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = initPresenter();

        mActivity = getActivity();
        mContext = getContext();

        init();

        onClick();
    }

    // 点击事件
    private void onClick () {
        if (!isFastClick()) {
            click();
        }
    }
}
