package com.example.devfest.profiler_hands_on.cpu;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class HeavyView extends View {

    public HeavyView(Context context) {
        super(context);
    }

    public HeavyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HeavyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public HeavyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (!isInEditMode()) {
            SystemClock.sleep(40L);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (!isInEditMode()) {
            SystemClock.sleep(40L);
        }
    }
}
