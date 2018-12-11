package com.example.llyc.myapp.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * author   Bright
 * date     2018/10/28 20:54
 * desc
 * RecycleView的分割线
 */
public class ColorDividerItemDecoration extends RecyclerView.ItemDecoration {
    private Paint mPaint;
    private int mDividerHeight;//分割线高度

    public ColorDividerItemDecoration() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);//抗锯齿
        mPaint.setColor(Color.RED);
    }

    /**
     * @param outRect 外侧边框,类似于margin
     * @param view    item条目view,出去margin的中间部分
     * @param parent  RecycleView
     * @param state   RecycleView的当前状态
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        //第一个item不要绘制分割线
        if (parent.getChildAdapterPosition(view) != 0) {
            outRect.top = 1;
            //分割线是1px
            mDividerHeight = 1;
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int index = parent.getChildAdapterPosition(view);
            if (index == 0) {//第一个item不需要绘制
                continue;
            }
            float dividerLeft = parent.getPaddingLeft();
            float dividerTop = view.getTop() - mDividerHeight;
            float dividerRight = parent.getWidth() - parent.getPaddingRight();
            float dividerBottom = view.getTop();

            c.drawRect(dividerLeft, dividerTop, dividerRight, dividerBottom, mPaint);
        }
    }
}
