package com.example.xuchichi.phoneassistant.ui.weiget;

import android.content.Context;
import android.icu.util.Measure;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xuchichi on 2018/4/16.
 */

public class LableView extends ViewGroup {


    public LableView(Context context) {
        super(context, null);
    }

    public LableView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public LableView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int lineHeight = 0;
        int lineWidth = 0;
        int width = 0;
        int height = 0;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);


        int count = getChildCount();

        for (int i = 0; i < count; i++) {

            View child = getChildAt(i);

            measureChild(child, widthMeasureSpec, heightMeasureSpec);

            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

            int childWidth = child.getMeasuredWidth() + lp.rightMargin + lp.leftMargin;

            int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;


            if (lineWidth + childWidth > width) {

                width = Math.max(width, lineWidth);

                height = childHeight;

                lineWidth = childWidth;

                lineHeight += childHeight;

            } else {

                lineWidth += childWidth;

                lineHeight = Math.max(lineHeight, childHeight);
            }

            if (i == count) {

                height += lineHeight;

                width = Math.max(lineWidth, width);
            }

            setMeasuredDimension(widthMode == MeasureSpec.AT_MOST ? width : widthSize,
                    heightMode == MeasureSpec.AT_MOST ? height : heightSize);

        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();

        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);


        }
    }
}
