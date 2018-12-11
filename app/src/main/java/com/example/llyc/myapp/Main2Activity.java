package com.example.llyc.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        /*ProgressDialog progressDialog = ProgressDialog.show(this, "提示", "正在加载数据,请稍后...");
        SystemClock.sleep(2000);
        progressDialog.dismiss();*/
    }
}
