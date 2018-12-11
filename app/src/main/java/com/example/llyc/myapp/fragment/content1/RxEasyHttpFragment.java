package com.example.llyc.myapp.fragment.content1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.llyc.myapp.R;
import com.example.llyc.myapp.base.BaseFragment;
import com.example.llyc.myapp.bean.Api;
import com.example.llyc.myapp.bean.ApkUpdateEntity;
import com.example.llyc.myapp.utils.JsonUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.CallBackProxy;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Bright on 2018/11/2.
 *
 * @Describe RxEasyHttp
 * @Called
 */
public class RxEasyHttpFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = RxEasyHttpFragment.class.getSimpleName();
    @Bind(R.id.btn_post1)
    Button mBtnPost1;
    @Bind(R.id.btn_post2)
    Button mBtnPost2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content1_fragment_rx_easy_http, container, false);
        ButterKnife.bind(this, rootView);
        initListener();//初始化监听
        return rootView;
    }

    private void initListener() {
        mBtnPost1.setOnClickListener(this);
        mBtnPost2.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
            case R.id.btn_post1:
                post1();
                break;
            case R.id.btn_post2:
                post2();
                break;
        }
    }

    private void post2() {
        Map<String, Object> map = new HashMap<>();
//        { "mobile":"15112341234", "appType": 1 }
        map.put("mobile", "15989469069");
        map.put("appType", 1);
//        http://60.205.177.21/new_gongdi/AppInstallInfo/getNewAppInfo
        String url = "http://60.205.177.21/new_gongdi/AppInstallInfo/getNewAppInfo";//版本更新路径
        Log.d(TAG,"url=="+url);
        EasyHttp.post(url)
                .params("paramJson", JsonUtils.mapToJson(map))
                .execute(new CallBackProxy<Api<ApkUpdateEntity>, ApkUpdateEntity>(new SimpleCallBack<ApkUpdateEntity>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.d(TAG, "请求失败..");
                        e.printStackTrace();
                    }

                    @Override
                    public void onSuccess(ApkUpdateEntity apkUpdateEntity) {
                        Log.d(TAG, "请求成功.." + apkUpdateEntity);
                    }
                }) {
                });
    }

    private void post1() {

    }
}
