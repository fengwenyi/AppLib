package com.fengwenyi.app.applib.jk;

/**
 * 回调接口
 * @author Wenyi Feng
 */

public interface ICallback <T> {

    /**
     * if success return data
     * @param data T data
     */
    void onSuccess (T data);

    /**
     * if fail or error tip message
     * @param msg Message String
     */
    void onFail (String msg);

}
