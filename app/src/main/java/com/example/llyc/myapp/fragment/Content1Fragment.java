package com.example.llyc.myapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.llyc.myapp.R;
import com.example.llyc.myapp.activity.Content1Activity;
import com.example.llyc.myapp.base.BaseFragment;
import com.example.llyc.myapp.bean.TitleBean;
import com.example.llyc.myapp.view.ColorDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Bright on 2018/10/29.
 *
 * @Describe
 * @Called
 */
public class Content1Fragment extends BaseFragment {
    @Bind(R.id.rv_content1)
    RecyclerView mRvContent1;
    private List<TitleBean> mList;
    private Content1Adapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_content1, null);
        ButterKnife.bind(this, rootView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvContent1.setLayoutManager(layoutManager);
        mAdapter = new Content1Adapter();
        mRvContent1.setAdapter(mAdapter);
        mRvContent1.addItemDecoration(new ColorDividerItemDecoration());
        return rootView;
    }

    @Override
    public void initData() {
        mList = new ArrayList<>();
        mList.add(new TitleBean(0,"rxEasyHttp","网络请求框架"));
        mList.add(new TitleBean(1,"HaveExaminingFragment","HaveExaminingFragment"));
        mList.add(new TitleBean(2,"HaveExaminedFragment","HaveExaminedFragment"));
        mList.add(new TitleBean(3,"Activity Test","需要用到Activity的知识点."));
        mList.add(new TitleBean(4,"Recyclerview","树形结构的Recyclerview."));
        mList.add(new TitleBean(5,"时间,日期控件","时间,日期控件"));
        mList.add(new TitleBean(6,"ExpandableListView","ExpandableListView(可折叠列表)的基本使用"));
        for (int i = 100; i < 120; i++) {
            TitleBean titleBean = new TitleBean(i, "title--" + i, "description--" + i);
            mList.add(titleBean);
        }
    }

    @Override
    public void init() {
        super.init();
    }

    /**
     * @author syl
     * create at 2018/10/29
     * description:数据和试图绑定,点击条目,
     */
    class Content1Adapter extends RecyclerView.Adapter<Content1ViewHolder> {
        /**
         * @param viewGroup RecycleView
         * @param i         position
         * @return
         */
        @NonNull
        @Override
        public Content1ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(getActivity()).inflate(R.layout.rv_item_content1, viewGroup, false);
            itemView.setOnClickListener(new View.OnClickListener() {//给条目添加点击事件
                @Override
                public void onClick(View v) {
                    int position = mRvContent1.getChildAdapterPosition(v);
                    Toast.makeText(getActivity(), position + "---was clicked", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), Content1Activity.class);
                    TitleBean titleBean = mList.get(position);
                    intent.putExtra("titleBean", titleBean);
                    getActivity().startActivity(intent);
                }
            });
            return new Content1ViewHolder(itemView);
        }

        /**
         * 试图和数据的绑定
         *
         * @param holder
         * @param i      position
         */
        @Override
        public void onBindViewHolder(@NonNull Content1ViewHolder holder, int i) {
            TitleBean titleBean = mList.get(i);
            holder.tvTitle.setText(titleBean.getTitle());
            holder.tvDescription.setText(titleBean.getDescription());
        }

        /**
         * 返回数据集长度
         *
         * @return
         */
        @Override
        public int getItemCount() {
            if (mList != null && mList.size() > 0) {
                return mList.size();
            }
            return 0;
        }
    }

    /**
     * @author syl
     * create at 2018/10/29
     * description:ViewHolder
     */
    class Content1ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvDescription;

        public Content1ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
