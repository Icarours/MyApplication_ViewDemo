package com.example.llyc.myapp.fragment.content1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.llyc.myapp.R;
import com.example.llyc.myapp.bean.Person;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Bright on 2018/11/8.
 *
 * @Describe
 * @Called
 */
public class HaveExaminingFragment extends Fragment {
    @Bind(R.id.rv_have_examining)
    RecyclerView mRvHaveExamining;
    List<Person> mPersonList = new ArrayList<>();//数据集

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_have_examining, container, false);
        ButterKnife.bind(this, rootView);
        initData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvHaveExamining.setLayoutManager(layoutManager);
        HavingExamineAdapter adapter = new HavingExamineAdapter(R.layout.rv_item_person, mPersonList);
        mRvHaveExamining.setAdapter(adapter);
        return rootView;
    }

    /**
     * @author syl
     * create at 2018/11/8
     * description:
     */
    class HavingExamineAdapter extends BaseQuickAdapter<Person, BaseViewHolder> {
        public HavingExamineAdapter(int layoutResId, @Nullable List<Person> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, Person item) {
            helper.setText(R.id.tv_id, item.getId());
            helper.setText(R.id.tv_name, item.getName());
            helper.setText(R.id.tv_mobile, item.getMobile());
        }
    }
    /**
     * 静态传值
     *
     * @param key
     * @return
     */
    public static HaveExaminingFragment newInstance(String key) {
        HaveExaminingFragment fragment = new HaveExaminingFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key", key);
        fragment.setArguments(bundle);
        return fragment;
    }
    public void initData() {
        for (int i = 0; i < 60; i++) {
            Person person = new Person(i + "", "HaveExaminingFragment-test name--" + i, "test mobile phone--" + i);
            mPersonList.add(person);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
