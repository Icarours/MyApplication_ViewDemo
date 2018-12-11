package com.example.llyc.myapp.fragment.content1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.llyc.myapp.Main2Activity;
import com.example.llyc.myapp.R;
import com.example.llyc.myapp.activity.Btn3Activity;
import com.example.llyc.myapp.activity.CardView2Activity;
import com.example.llyc.myapp.activity.CardView3Activity;
import com.example.llyc.myapp.activity.ClipChildren2Activity;
import com.example.llyc.myapp.activity.CardViewActivity;
import com.example.llyc.myapp.activity.ClipChildrenActivity;
import com.example.llyc.myapp.activity.ViewActivity;
import com.example.llyc.myapp.activity.WebViewQQActivity;
import com.example.llyc.myapp.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Bright on 2018/11/21.
 *
 * @Describe
 * @Called
 */
public class ActivityTestFragment extends BaseFragment {
    @Bind(R.id.btn1)
    Button mBtn1;
    @Bind(R.id.btn2)
    Button mBtn2;
    @Bind(R.id.btn_card_view1)
    Button mBtn3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_activity_test, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn_card_view1, R.id.btn_card_view2, R.id.btn_card_view3,
            R.id.btn3, R.id.btn_clip_children,R.id.btn_clip_children2,R.id.btn_web_view_qq})
    public void onViewClick(View view) {
        Intent intent;
        switch (view.getId()) {
            default:
            case R.id.btn1:
                intent = new Intent(getContext(), Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                intent = new Intent(getContext(), ViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_card_view1:
                intent = new Intent(getContext(), CardViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_card_view2:
                intent = new Intent(getContext(), CardView2Activity.class);
                startActivity(intent);
                break;
            case R.id.btn_card_view3:
                intent = new Intent(getContext(), CardView3Activity.class);
                startActivity(intent);
                break;
            case R.id.btn3:
                intent = new Intent(getContext(), Btn3Activity.class);
                startActivity(intent);
                break;
            case R.id.btn_clip_children:
                intent = new Intent(getContext(), ClipChildrenActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_clip_children2:
                intent = new Intent(getContext(), ClipChildren2Activity.class);
                startActivity(intent);
                break;
            case R.id.btn_web_view_qq:
                intent = new Intent(getContext(), WebViewQQActivity.class);
                startActivity(intent);
                break;
        }
    }
}
