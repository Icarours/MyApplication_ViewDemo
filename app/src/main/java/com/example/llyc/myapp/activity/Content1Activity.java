package com.example.llyc.myapp.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.llyc.myapp.R;
import com.example.llyc.myapp.bean.TitleBean;
import com.example.llyc.myapp.fragment.content1.ActivityTestFragment;
import com.example.llyc.myapp.fragment.content1.DatePicker1Fragment;
import com.example.llyc.myapp.fragment.content1.ExpandableListViewFragment;
import com.example.llyc.myapp.fragment.content1.HaveExaminedFragment;
import com.example.llyc.myapp.fragment.content1.HaveExaminingFragment;
import com.example.llyc.myapp.fragment.content1.Rv1Fragment;
import com.example.llyc.myapp.fragment.content1.RxEasyHttpFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author syl
 * create at 2018/11/29
 * description:Fragment的具体类容
 */
public class Content1Activity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.fl_activity_content1)
    FrameLayout mFlActivityContent1;
    private TitleBean mTitleBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_content1);
        ButterKnife.bind(this);
        mTitleBean = (TitleBean) getIntent().getSerializableExtra("titleBean");
        initToolBar();
        initFragment();
    }

    private void initFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        int id = mTitleBean.getId();
        if (0 == id) {
            transaction.replace(R.id.fl_activity_content1, new RxEasyHttpFragment());
        } else if (1 == id) {
            transaction.replace(R.id.fl_activity_content1, new HaveExaminingFragment());
        } else if (2 == id) {
            transaction.replace(R.id.fl_activity_content1, new HaveExaminedFragment());
        } else if (3 == id) {
            transaction.replace(R.id.fl_activity_content1, new ActivityTestFragment());
        } else if (4 == id) {
            transaction.replace(R.id.fl_activity_content1, new Rv1Fragment());
        } else if (5 == id) {
            transaction.replace(R.id.fl_activity_content1, new DatePicker1Fragment());
        } else if (6 == id) {
            transaction.replace(R.id.fl_activity_content1, new ExpandableListViewFragment());
        }
        transaction.commit();
    }

    private void initToolBar() {
        mToolbar.setTitle(mTitleBean.getTitle());
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
                        Toast.makeText(Content1Activity.this, "action_search", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_notification:
                        Toast.makeText(Content1Activity.this, "action_notification", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_item_one:
                        Toast.makeText(Content1Activity.this, "action_item_one", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_item_two:
                        Toast.makeText(Content1Activity.this, "action_item_two", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }
}
