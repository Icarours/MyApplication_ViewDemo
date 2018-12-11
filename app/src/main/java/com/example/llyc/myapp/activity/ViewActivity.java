package com.example.llyc.myapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.llyc.myapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author syl
 * create at 2018/11/23
 * description:测试一些控件1
 */
public class ViewActivity extends AppCompatActivity {

    private static final String TAG = ViewActivity.class.getSimpleName();
    @Bind(R.id.rb_test)
    RadioButton mRbTest;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_view);
        ButterKnife.bind(this);
        initListener();
        initToolBar();
    }

    private void initToolBar() {
        mToolbar.setTitle("ViewActivity");
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
                        Toast.makeText(ViewActivity.this, "action_search", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_notification:
                        Toast.makeText(ViewActivity.this, "action_notification", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_item_one:
                        Toast.makeText(ViewActivity.this, "action_item_one", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_item_two:
                        Toast.makeText(ViewActivity.this, "action_item_two", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }

    private void initListener() {
        mRbTest.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {

            }

            @Override
            public void onViewDetachedFromWindow(View v) {

            }
        });
        mRbTest.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {

            }
        });
        mRbTest.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
//                    Toast.makeText(ViewActivity.this, "RadioButton was checked..", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "RadioButton was checked..");
                } else {
//                    Toast.makeText(ViewActivity.this, "RadioButton was unchecked..", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "RadioButton was unchecked..");
                }
            }
        });
        mRbTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRbTest.toggle();
                boolean checked = mRbTest.isChecked();
                if (checked) {
                    Toast.makeText(ViewActivity.this, "OnClickListener--RadioButton was checked..", Toast.LENGTH_SHORT).show();
                } else {
                    mRbTest.setChecked(false);
                    Toast.makeText(ViewActivity.this, "OnClickListener--RadioButton was unchecked..", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
