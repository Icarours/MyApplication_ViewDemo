package com.example.llyc.myapp.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.llyc.myapp.R;
import com.example.llyc.myapp.fragment.content1.HaveExaminedFragment;
import com.example.llyc.myapp.fragment.content1.HaveExaminingFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FileManageActivity extends AppCompatActivity {

    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.searchView)
    SearchView mSearchView;
    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.vp)
    ViewPager mVp;
    private List<String> mListTitle;
    private List<Fragment> mFragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_file_manage);
        ButterKnife.bind(this);
        initToolBar();
        initFragment();
    }
    private void initFragment() {
        mListTitle = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            mListTitle.add("title"+i);
        }
        mFragments = new ArrayList<>();

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < mListTitle.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(mListTitle.get(i)));
        }
        HaveExaminedFragment haveExaminedFragment = HaveExaminedFragment.newInstance("haveExaminedFragment");
        HaveExaminingFragment haveExaminingFragment = HaveExaminingFragment.newInstance("haveExaminingFragment");
        mFragments.add(haveExaminedFragment);
        mFragments.add(haveExaminingFragment);

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mListTitle.get(position);
            }
        };
        mVp.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mVp);
    }

    private void initToolBar() {
        mToolbar.setTitle("");
        mTvTitle.setText("档案审核");
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mToolbar.inflateMenu(R.menu.menu_normal);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_search:
                        Toast.makeText(FileManageActivity.this, "action_examine", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(FileManageActivity.this, FileManageDetailActivity.class);
//                        startActivity(intent);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }
}
