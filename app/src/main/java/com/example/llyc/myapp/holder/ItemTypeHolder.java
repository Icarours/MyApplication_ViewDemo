package com.example.llyc.myapp.holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.llyc.myapp.R;
import com.example.llyc.myapp.bean.AlarmBean;
import com.trecyclerview.holder.AbsHolder;
import com.trecyclerview.holder.AbsItemHolder;

/**
 * Created by Bright on 2018/12/15.
 *
 * @Describe
 * @Called
 */
public class ItemTypeHolder extends AbsItemHolder<AlarmBean, ItemTypeHolder.ViewHolder> {
    public ItemTypeHolder(Context context) {
        super(context);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.type;
    }

    @Override
    public ViewHolder createViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull AlarmBean item) {
        TextView tv1 = holder.itemView.findViewById(R.id.tv_1);
        tv1.setText(item.toString());
    }

    static class ViewHolder extends AbsHolder {

        ViewHolder(@NonNull final View itemView) {
            super(itemView);
        }

    }

}
