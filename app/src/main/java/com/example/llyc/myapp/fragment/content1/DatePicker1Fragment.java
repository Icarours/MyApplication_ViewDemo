package com.example.llyc.myapp.fragment.content1;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.llyc.myapp.R;
import com.example.llyc.myapp.base.BaseFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Bright on 2018/12/4.
 *
 * @Describe 日期时间控件
 * @Called
 */
public class DatePicker1Fragment extends BaseFragment {
    private static final String TAG = DatePicker1Fragment.class.getSimpleName();
    @Bind(R.id.dp1)
    DatePicker mDp1;
    @Bind(R.id.btn_date_dialog)
    Button mBtnDateDialog;
    @Bind(R.id.button3)
    Button mButton3;
    @Bind(R.id.tv_date1)
    TextView mTvDate1;
    @Bind(R.id.tv_date2)
    TextView mTvDate2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_date_picker, container, false);
        ButterKnife.bind(this, rootView);
        mDp1.init(2018, 11, 4, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // 获取一个日历对象，并初始化为当前选中的时间
                Calendar calendar = Calendar.getInstance();
                int calenderYear = calendar.get(Calendar.YEAR);
                int calenderMonth = calendar.get(Calendar.MONTH);//月份要+1
                int calenderDay = calendar.get(Calendar.DATE);
                calendar.set(year, monthOfYear, dayOfMonth);
                SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日  HH:mm");
                SimpleDateFormat format2 = new SimpleDateFormat("yyyy年MM月dd日");
                Toast.makeText(getContext(),
                        format.format(calendar.getTime()), Toast.LENGTH_SHORT)
                        .show();
                Log.d(TAG, "format==" + format.format(calendar.getTime()));
                Log.d(TAG, "format2==" + format2.format(calendar.getTime()));
                DateFormat dateInstance = SimpleDateFormat.getDateInstance();
                String date1 = dateInstance.format(calendar.getTime());
                mTvDate1.setText(date1);
                mTvDate2.setText(calenderYear + "-" + (calenderMonth + 1) + "-" + calenderDay);
            }
        });
        return rootView;
    }

    @OnClick({R.id.btn_date_dialog})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_date_dialog:
                showDateDialog();
                break;
            default:
                break;
        }
    }

    private void showDateDialog() {
        DatePickerDialog datePicker = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                Toast.makeText(getContext(), year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
            }
        }, 2013, 7, 20);
        datePicker.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
