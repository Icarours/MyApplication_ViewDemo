package com.example.llyc.myapp.fragment.content1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.llyc.myapp.R;
import com.example.llyc.myapp.adapter.MyBaseExpandableListAdapter;
import com.example.llyc.myapp.base.BaseFragment;
import com.example.llyc.myapp.bean.Group;
import com.example.llyc.myapp.bean.Item;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Bright on 2018/12/7.
 *
 * @Describe
 * @Called
 */
public class ExpandableListViewFragment extends BaseFragment {
    @Bind(R.id.ex_lv)
    ExpandableListView mExLv;
    private ArrayList<Group> gData = null;//组的名称
    private ArrayList<ArrayList<Item>> iData = null;//
    private ArrayList<Item> lData = null;//组下面的条目
    private Context mContext;
    private MyBaseExpandableListAdapter myAdapter = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_expandable_list_view, container, false);
        ButterKnife.bind(this, rootView);
        mContext = getActivity();
        initView();
        return rootView;
    }

    private void initView() {
        //数据准备
        gData = new ArrayList<Group>();
        iData = new ArrayList<ArrayList<Item>>();
        gData.add(new Group("AD"));
        gData.add(new Group("AP"));
        gData.add(new Group("TANK"));

        lData = new ArrayList<Item>();

        //AD组
        lData.add(new Item(R.mipmap.iv_lol_icon3,"剑圣"));
        lData.add(new Item(R.mipmap.iv_lol_icon4,"德莱文"));
        lData.add(new Item(R.mipmap.iv_lol_icon13,"男枪"));
        lData.add(new Item(R.mipmap.iv_lol_icon14,"韦鲁斯"));
        iData.add(lData);
        //AP组
        lData = new ArrayList<Item>();
        lData.add(new Item(R.mipmap.iv_lol_icon1, "提莫"));
        lData.add(new Item(R.mipmap.iv_lol_icon7, "安妮"));
        lData.add(new Item(R.mipmap.iv_lol_icon8, "天使"));
        lData.add(new Item(R.mipmap.iv_lol_icon9, "泽拉斯"));
        lData.add(new Item(R.mipmap.iv_lol_icon11, "狐狸"));
        iData.add(lData);
        //TANK组
        lData = new ArrayList<Item>();
        lData.add(new Item(R.mipmap.iv_lol_icon2, "诺手"));
        lData.add(new Item(R.mipmap.iv_lol_icon5, "德邦"));
        lData.add(new Item(R.mipmap.iv_lol_icon6, "奥拉夫"));
        lData.add(new Item(R.mipmap.iv_lol_icon10, "龙女"));
        lData.add(new Item(R.mipmap.iv_lol_icon12, "狗熊"));
        iData.add(lData);

        myAdapter = new MyBaseExpandableListAdapter(gData,iData,mContext);
        mExLv.setAdapter(myAdapter);

        //为列表设置点击事件
        mExLv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(mContext, "你点击了：" + iData.get(groupPosition).get(childPosition).getiName(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
