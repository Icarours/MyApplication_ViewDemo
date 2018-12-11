package com.example.llyc.myapp.bean;

/**
 * Created by Bright on 2018/11/16.
 *
 * @Describe
 * @Called
 */
public class BaseApi {
    /**
     * code : 1018
     * data :
     * message : 您上传的身份证照片已被他人认证，请重新上传您的身份证照
     */

    private int code;
    private String data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isOk() {
        return this.code == 200;
    }
}
