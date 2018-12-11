package com.example.llyc.myapp.bean;

import java.io.Serializable;

/**
 * Created by Bright on 2018/11/2.
 *
 * @Describe Apk更新的实体类
 * @Called
 */
public class ApkUpdateEntity implements Serializable {

    /**
     * updateurl : http://60.205.177.21/中铁1.1.5.18.apk
     * versionName : 1.1.5.19
     * upgradeinfo : 新增封浜工地兼容查看nvr和摄像头不能同时查看直播的功能，解决安卓8.0以下音柱添加不能添加定时任务bug,以及解决若干bug
     * appname : 智慧工地
     * versionCode : 1
     */

    private String updateurl;
    private String versionName;
    private String upgradeinfo;
    private String appname;
    private String versionCode;

    @Override
    public String toString() {
        return "ApkUpdateEntity{" +
                "updateurl='" + updateurl + '\'' +
                ", versionName='" + versionName + '\'' +
                ", upgradeinfo='" + upgradeinfo + '\'' +
                ", appname='" + appname + '\'' +
                ", versionCode='" + versionCode + '\'' +
                '}';
    }

    public ApkUpdateEntity() {
    }

    public ApkUpdateEntity(String updateurl, String versionName, String upgradeinfo, String appname, String versionCode) {
        this.updateurl = updateurl;
        this.versionName = versionName;
        this.upgradeinfo = upgradeinfo;
        this.appname = appname;
        this.versionCode = versionCode;
    }

    public String getUpdateurl() {
        return updateurl;
    }

    public void setUpdateurl(String updateurl) {
        this.updateurl = updateurl;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getUpgradeinfo() {
        return upgradeinfo;
    }

    public void setUpgradeinfo(String upgradeinfo) {
        this.upgradeinfo = upgradeinfo;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }
}
