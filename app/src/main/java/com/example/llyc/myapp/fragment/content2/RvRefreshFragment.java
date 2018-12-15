package com.example.llyc.myapp.fragment.content2;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSONObject;
import com.example.llyc.myapp.R;
import com.example.llyc.myapp.base.BaseFragment;
import com.example.llyc.myapp.bean.AlarmBean;
import com.example.llyc.myapp.bean.Api;
import com.example.llyc.myapp.bean.BannerVo;
import com.example.llyc.myapp.bean.BaseApi;
import com.example.llyc.myapp.holder.BannerHolder;
import com.example.llyc.myapp.holder.ItemTypeHolder;
import com.example.llyc.myapp.utils.JsonUtils;
import com.trecyclerview.SwipeRecyclerView;
import com.trecyclerview.adapter.DelegateAdapter;
import com.trecyclerview.adapter.ItemData;
import com.trecyclerview.footview.FootViewHolder;
import com.trecyclerview.listener.OnLoadMoreListener;
import com.trecyclerview.pojo.FootVo;
import com.trecyclerview.progressindicator.ProgressStyle;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.CallBackProxy;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bright on 2018/12/15.
 *
 * @Describe RecyclerView 刷新框架
 * @Called
 */
public class RvRefreshFragment extends BaseFragment {
    private static final String TAG = RvRefreshFragment.class.getSimpleName();
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private SwipeRecyclerView tRecyclerView;
    private ItemData itemData = new ItemData();
    //    private List<AlarmBean> itemData;
    private DelegateAdapter adapter;

    private int indexPage = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rv_refresh, container, false);

        tRecyclerView = rootView.findViewById(R.id.recycler_view);
        mSwipeRefreshLayout = rootView.findViewById(R.id.swipe_refresh_layout);
//        itemData = new ItemData();


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        tRecyclerView.setLayoutManager(layoutManager);
        setListener();
        initData2();
//        initList();//indexPage = 1
        //设置刷新时动画的颜色，可以设置4个
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setProgressViewOffset(false, 0, 60);
            mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_blue_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        }
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(true);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        itemData.clear();
                        itemData.add(new BannerVo());
//                        for (int i = 0; i < 10; i++) {
//                            itemData.add(new BaseApi("条目--" + i));
//                        }
                        initList(1);
                        tRecyclerView.refreshComplete(itemData, false);
                        mSwipeRefreshLayout.setRefreshing(false);
                    }

                }, 2000);
            }
        });

        return rootView;
    }

    private void initAdapter() {
        if (adapter == null) {
            adapter = new DelegateAdapter.Builder()
                    .bind(BannerVo.class, new BannerHolder(getContext()))//Banner轮播图
                    .bind(AlarmBean.class, new ItemTypeHolder(getContext()))//Item条目
                    .bind(FootVo.class, new FootViewHolder(getContext(), ProgressStyle.Pacman))
                    .build();
            tRecyclerView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    private void setListener() {
        tRecyclerView.addOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        indexPage += 1;
                        initList(indexPage);
                    }

                }, 2000);
            }
        });
    }

    private void initData2() {
        itemData.clear();
        itemData.add(new BannerVo());
//        for (int i = 0; i < 20; i++) {
//            itemData.add(new ItemVo("条目init--" + i));
//        }
        initList(1);
    }

    public void initList(int i) {
//        http://cloud.lanlyc.cn/new_gongdi/warnMessage/getWarnMessageList?paramJson=
// {"pageNumber":"1","pageSize":"16"}
        Map<String, String> map = new HashMap<>();
        map.put("mobile", "15989469069");
        map.put("pageNumber", i + "");
        map.put("pageSize", 12 + "");
        String url = "http://cloud.lanlyc.cn/new_gongdi/warnMessage/getWarnMessageList";//报警消息
        Log.d(TAG, "url==" + url);
        EasyHttp.post(url)
                .params("paramJson", JsonUtils.mapToJson(map))
                .execute(new CallBackProxy<Api<String>, String>(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.d(TAG, "网络请求失败");
                    }

                    @Override
                    public void onSuccess(String result) {
                        Log.d(TAG, "result==" + result);
                        BaseApi baseApi = JSONObject.parseObject(result, BaseApi.class);
                        if (baseApi.isOk()) {
                            String apiData = baseApi.getData();
                            if (apiData != null && !"".equals(apiData)) {
                                List<AlarmBean> alarmBeans = JSONObject.parseArray(apiData, AlarmBean.class);
                                if (alarmBeans.size() > 0)
                                    itemData.addAll(alarmBeans);
                                initAdapter();
                                if (indexPage == 1) {
                                    tRecyclerView.refreshComplete(itemData, false);
                                } else {
                                    if (alarmBeans.size() % 12 == 0) {
                                        tRecyclerView.loadMoreComplete(alarmBeans, false);
                                    } else {
                                        tRecyclerView.loadMoreComplete(alarmBeans, true);
                                    }
                                }
                            } else {
                                Log.d(TAG, "data 数据集为空");
                            }
                        } else {
                            Log.d(TAG, "code 返回值不为200");
                        }
                    }
                }) {
                });
    }
}
