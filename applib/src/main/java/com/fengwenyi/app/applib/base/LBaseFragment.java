package com.fengwenyi.app.applib.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Library Base Fragment
 * @author Wenyi Feng
 */

public abstract class LBaseFragment<T extends LBasePresenter> extends Fragment {

    protected T presenter;

    public abstract void init ();

    public abstract T initPresenter ();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = initPresenter();

        init();
    }
}
