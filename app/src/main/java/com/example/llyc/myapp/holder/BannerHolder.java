package com.example.llyc.myapp.holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.llyc.myapp.R;
import com.example.llyc.myapp.bean.BannerVo;
import com.trecyclerview.holder.AbsHolder;
import com.trecyclerview.holder.AbsItemHolder;

/**
 * Created by Bright on 2018/12/15.
 *
 * @Describe
 * @Called
 */
public class BannerHolder extends AbsItemHolder<BannerVo, BannerHolder.ViewHolder> {
    public BannerHolder(Context context) {
        super(context);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.banner;
    }

    @Override
    public ViewHolder createViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull BannerVo item) {
        RecyclerView.LayoutParams clp = (RecyclerView.LayoutParams) holder.mBannerView.getLayoutParams();
        if (clp instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) clp).setFullSpan(true);
        }
    }

    static class ViewHolder extends AbsHolder {

        private RelativeLayout mBannerView;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mBannerView=getViewById(R.id.rl_root_view);
        }

    }

}
