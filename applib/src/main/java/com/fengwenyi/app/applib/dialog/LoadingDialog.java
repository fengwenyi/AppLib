package com.fengwenyi.app.applib.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.fengwenyi.app.applib.R;

/**
 * Dialog loading
 * <p>
 *     可以自定义文字，
 *     可以自定义是否文字是否显示，
 *     可以自定义点击边框外的部分是否可以取消
 *     可以自定义点击返回键是否可取消
 * </p>
 * @author Wenyi Feng
 */

public class LoadingDialog extends Dialog {

    public LoadingDialog(@NonNull Context context) {
        super(context);
    }

    public LoadingDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public LoadingDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public static class Builder {

        private Context mContext;
        private String msg = "Loading";
        private boolean isShowMsg = true; // 是否显示文字提示
        private boolean isCancelable = true; // 点击返回键是否可以取消
        private boolean isCancelOutside = false; // 点击边框外是否取消

        public Builder (Context context) {
            this.mContext = context;
        }

        /**
         * 设置提示文字
         * @param msg 提示文字
         * @return Builder
         */
        public Builder setMsg (String msg) {
            this.msg = msg;
            return this;
        }

        /**
         * 设置是否显示文字提示
         * @param isShowMsg 是否显示文字提示，默认显示
         * @return Builder
         */
        public Builder setShowMsg (boolean isShowMsg) {
            this.isShowMsg = isShowMsg;
            return this;
        }

        /**
         * 设置点击返回键是否取消
         * @param isCancelable 点击返回键是否取消， 默认取消
         * @retur Builder
         */
        public Builder setCancelable (boolean isCancelable) {
            this.isCancelable = isCancelable;
            return this;
        }

        public Builder setCancelOutside (boolean isCancelOutside) {
            this.isCancelOutside = isCancelOutside;
            return this;
        }

        public LoadingDialog create () {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            View view = inflater.inflate(R.layout.dialog_loading, null);
            LoadingDialog loadingDialog = new LoadingDialog(mContext, R.style.DialogLoading);
            TextView tvMsg = view.findViewById(R.id.loading_msg);
            if (isShowMsg) {
                tvMsg.setText(msg);
                tvMsg.setVisibility(View.VISIBLE);
            } else {
                tvMsg.setVisibility(View.GONE);
            }
            loadingDialog.setContentView(view);
            loadingDialog.setCancelable(isCancelable);
            loadingDialog.setCanceledOnTouchOutside(isCancelOutside);
            return loadingDialog;
        }
    }
}
