package com.fengwenyi.app.applib.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.fengwenyi.app.applib.tool.IconTextUtil;

/**
 * Icon View
 * @author Wenyi Feng
 */

public class IconView extends AppCompatTextView {

    public IconView(Context context) {
        super(context);
        init (context);
    }

    public IconView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init (context);
    }

    public IconView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init (context);
    }

    private void init (Context context) {
        this.setTypeface(IconTextUtil.getTypeface(context));
    }
}
