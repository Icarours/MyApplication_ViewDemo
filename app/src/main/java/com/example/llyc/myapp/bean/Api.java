package com.example.llyc.myapp.bean;

import com.zhouyou.http.model.ApiResult;

/**
 * Created by Bright on 2018/11/1.
 *
 * @Describe 根据需要继承重写ApiResult
 * @Called
 */
public class Api<T> extends ApiResult<T> {
    private String message;

    public String getMessage() {
        return message;
    }

    public boolean isOk() {
        return getCode() == 200;
    }
}
