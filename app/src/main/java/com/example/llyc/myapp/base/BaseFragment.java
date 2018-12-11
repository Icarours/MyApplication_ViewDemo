package com.example.llyc.myapp.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhouyou.http.EasyHttp;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by Bright on 2018/10/29.
 *
 * @Describe 虽然设置了基类,但是还是自己写onCreateView(),单纯的初始化数据可以使用initData()或者initData()
 * @Called
 */
public class BaseFragment extends Fragment {
    public List<Disposable> mDisposableList = new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        initData();
    }

    public void initData() {

    }

    /**
     * 接收Intent或者其他一些配置数据
     */
    public void init() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        cancelRequest();
    }

    /**
     * 取消网络请求
     */
    public void cancelRequest() {
        if (mDisposableList.size() > 0) {
            for (int i = 0; i < mDisposableList.size(); i++) {
                EasyHttp.cancelSubscription(mDisposableList.get(i));
            }
        }
    }
}
