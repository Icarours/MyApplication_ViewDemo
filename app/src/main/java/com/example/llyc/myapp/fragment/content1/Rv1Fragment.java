package com.example.llyc.myapp.fragment.content1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.llyc.myapp.R;
import com.example.llyc.myapp.base.BaseFragment;
import com.example.llyc.myapp.bean.Api;
import com.example.llyc.myapp.bean.BaseApi;
import com.example.llyc.myapp.bean.PersonEntity;
import com.example.llyc.myapp.config.GlideApp;
import com.example.llyc.myapp.utils.JsonUtils;
import com.example.llyc.myapp.view.ColorDividerItemDecoration;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.CallBackProxy;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;

/**
 * Created by Bright on 2018/11/29.
 *
 * @Describe
 * @Called
 */
public class Rv1Fragment extends BaseFragment {
    private static final String TAG = Rv1Fragment.class.getSimpleName();
    @Bind(R.id.rv_title)
    RecyclerView mRvTitle;
    @Bind(R.id.rv_content)
    RecyclerView mRvContent;

    private List<PersonEntity> mPersonEntities;
    private List<PersonEntity> mPersonEntities2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rv1, container, false);
        ButterKnife.bind(this, rootView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvContent.setLayoutManager(linearLayoutManager);
        ColorDividerItemDecoration itemDecoration = new ColorDividerItemDecoration();
        mRvContent.addItemDecoration(itemDecoration);
        return rootView;
    }

    @Override
    public void initData() {
        super.initData();
        initList(0);
        initListById(16);
    }

    class ContentAdapter extends BaseMultiItemQuickAdapter<PersonEntity, BaseViewHolder> {

        /**
         * Same as QuickAdapter#QuickAdapter(Context,int) but with
         * some initialization data.
         *
         * @param data A new list is created out of this one to avoid mutable list
         */
        public ContentAdapter(List<PersonEntity> data) {
            super(data);
            addItemType(0, R.layout.rv_item_content2);
            addItemType(1, R.layout.rv_item_text);
        }

        @Override
        protected void convert(BaseViewHolder helper, PersonEntity item) {
            if (item.getItemType() == 0) {
                helper.setText(R.id.tv_name, item.getPerson_name())
                        .setText(R.id.tv_phone, item.getMobile_phone())
                        .setText(R.id.tv_card_no, item.getCard_no())
                        .setText(R.id.tv_department_name, item.getDepartment_name())
                ;
//            GlideApp.with(this).load("http://goo.gl/gEgYUd").into(imageView);
                ImageView ivDoor = helper.getView(R.id.iv_door);
                GlideApp.with(getActivity())
                        .load(item.getPhoto_path())
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher2)
                        .into(ivDoor);
            } else if (item.getItemType() == 1) {
                helper.setText(R.id.tv_department, item.getDepartment_name());
            }
        }
    }

    private void initList(int deptId) {
        mPersonEntities = new ArrayList<>();
        /**
         * http://cloud.lanlyc.cn/new_gongdi/persDepartment/getPersonAndSubDepartmentByMobile
         *
         *  { "mobile":"15112341234", "keyword":"", "is_superuser":"1" }
         */
        //一进来是没有数据的
        Map<String, Object> map = new HashMap<>();
        map.put("mobile", "15989469069");

        map.put("is_superuser", "1");
        map.put("keyword", "");

        String url = "http://cloud.lanlyc.cn/new_gongdi/persDepartment/getPersonAndSubDepartmentByMobile";
//        String url = "http://cloud.lanlyc.cn/new_gongdi/persDepartment/getPersonAndSubDepartmentByDeptId";
        Disposable disposable = EasyHttp.post(url)
                .params("paramJson", JsonUtils.mapToJson(map))
                .execute(new CallBackProxy<Api<String>, String>(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.d(TAG, "定位失败.." + Thread.currentThread().getName());
                    }

                    @Override
                    public void onSuccess(String result) {
                        Log.d(TAG, "当前线程==" + Thread.currentThread().getName());
                        Log.d(TAG, "result:" + result);
                        BaseApi api = JSONObject.parseObject(result, BaseApi.class);
                        if (api.isOk()) {
                            String data = api.getData();
                            if (!"".equals(data) && null != data) {
                                JSONObject jsonObject = JSONObject.parseObject(data);
                                String sub_department_list = jsonObject.getString("sub_department_list");
                                String person_list = jsonObject.getString("person_list");
                                if (null != sub_department_list && !"".equals(sub_department_list)) {
                                    List<PersonEntity> people1 = JSONObject.parseArray(sub_department_list, PersonEntity.class);
                                    for (int i = 0; i < people1.size(); i++) {
                                        PersonEntity personEntity = people1.get(i);
                                        personEntity.setItemType(1);
                                    }
                                    mPersonEntities.addAll(people1);
                                } else {
                                    Log.d(TAG, "sub_department_list数据集为空..");
                                }
                                if (null != person_list && !"".equals(person_list)) {
                                    List<PersonEntity> people2 = JSONObject.parseArray(person_list, PersonEntity.class);
                                    for (int i = 0; i < people2.size(); i++) {
                                        people2.get(i).setItemType(0);
                                    }
                                    mPersonEntities.addAll(people2);
                                } else {
                                    Log.d(TAG, "person_list数据集为空..");
                                }
                                initAdapter();
                            } else {
                                Log.d(TAG, "data数据集为空");
                            }
                        } else {
                            Log.d(TAG, "code返回值不是200");
                        }
                    }
                }) {
                });
        mDisposableList.add(disposable);
    }

    private void initListById(int deptId) {
        mPersonEntities2 = new ArrayList<>();
        /**
         * { "mobile":"15112341234", "departmentId":"77", "keyword":"" }
         */
        //一进来是没有数据的
        Map<String, Object> map = new HashMap<>();
        map.put("mobile", "15989469069");
        map.put("departmentId", "16");
        map.put("keyword", "");

        String url = "http://cloud.lanlyc.cn/new_gongdi/persDepartment/getPersonAndSubDepartmentByDeptId";
        Disposable disposable = EasyHttp.post(url)
                .params("paramJson", JsonUtils.mapToJson(map))
                .execute(new CallBackProxy<Api<String>, String>(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.d(TAG, "定位失败.." + Thread.currentThread().getName());
                    }

                    @Override
                    public void onSuccess(String result) {
                        Log.d(TAG, "当前线程==" + Thread.currentThread().getName());
                        Log.d(TAG, "result:" + result);
                        BaseApi api = JSONObject.parseObject(result, BaseApi.class);
                        if (api.isOk()) {
                            String data = api.getData();
                            if (!"".equals(data) && null != data) {
                                JSONObject jsonObject = JSONObject.parseObject(data);
                                String sub_department_list = jsonObject.getString("sub_department_list");
                                String person_list = jsonObject.getString("person_list");
                                if (null != sub_department_list && !"".equals(sub_department_list)) {
                                    List<PersonEntity> people1 = JSONObject.parseArray(sub_department_list, PersonEntity.class);
                                    for (int i = 0; i < people1.size(); i++) {
                                        PersonEntity personEntity = people1.get(i);
                                        personEntity.setItemType(1);
                                    }
                                    mPersonEntities2.addAll(people1);
                                } else {
                                    Log.d(TAG, "sub_department_list数据集为空..");
                                }
                                if (null != person_list && !"".equals(person_list)) {
                                    List<PersonEntity> people2 = JSONObject.parseArray(person_list, PersonEntity.class);
                                    for (int i = 0; i < people2.size(); i++) {
                                        people2.get(i).setItemType(0);
                                    }
                                    mPersonEntities2.addAll(people2);
                                } else {
                                    Log.d(TAG, "person_list数据集为空..");
                                }
                                initAdapter();
                            } else {
                                Log.d(TAG, "data数据集为空");
                            }
                        } else {
                            Log.d(TAG, "code返回值不是200");
                        }
                    }
                }) {
                });
        mDisposableList.add(disposable);
    }
    private void initAdapter() {
        ContentAdapter adapter = new ContentAdapter(mPersonEntities);
        adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return 0;
            }
        });
        mRvContent.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                int itemViewType = adapter.getItemViewType(position);
                if (0 == itemViewType) {
                    Toast.makeText(getContext(), "0 == itemViewType", Toast.LENGTH_SHORT).show();
                } else if (1==itemViewType) {
                    Toast.makeText(getContext(), "1 == itemViewType", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
