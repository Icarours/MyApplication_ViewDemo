package com.example.llyc.myapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.llyc.myapp.R;

/**
 * @author syl
 * create at 2018/12/7
 * description:
 * 子控件高出父控件,在爷爷控件中设置
 * android:clipChildren="false"
 * 如果是ScrollView控件,还要在ScrollView控件设置
 * android:clipToPadding="false"
 */
public class ClipChildren2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view4);
    }
}
