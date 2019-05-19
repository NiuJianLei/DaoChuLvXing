package com.example.lenovo.daochulvxing.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by 灵风 on 2019/5/19.
 */

public class MyListView extends ListView {

    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int height = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, height);
    }

    @Override
    public void setSelection(int position) {
        super.setSelection(position);
    }
}
