package com.example.llyc.myapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.llyc.myapp.base.BaseFragment;
import com.example.llyc.myapp.fragment.Content1Fragment;
import com.example.llyc.myapp.fragment.Content2Fragment;
import com.example.llyc.myapp.fragment.Content3Fragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author syl
 * create at 2018/10/29
 * description:主界面
 */
public class MainActivity extends AppCompatActivity {


    @Bind(R.id.fl_content)
    FrameLayout mFlContent;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            BaseFragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new Content1Fragment();
                    transaction.replace(R.id.fl_content, fragment);
                    transaction.commit();
                    return true;
                case R.id.navigation_dashboard:
                    fragment = new Content2Fragment();
                    transaction.replace(R.id.fl_content, fragment);
                    transaction.commit();
                    return true;
                case R.id.navigation_notifications:
                    fragment = new Content3Fragment();
                    transaction.replace(R.id.fl_content, fragment);
                    transaction.commit();
                    return true;
            }
            return false;
        }
    };
    private BottomNavigationView mNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
        initListener();
    }

    private void initListener() {
        mNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void initView() {
        mNavigation = (BottomNavigationView) findViewById(R.id.navigation);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_content,new Content1Fragment());
        transaction.commit();
    }

}
