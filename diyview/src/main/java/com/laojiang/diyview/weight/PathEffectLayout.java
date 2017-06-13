package com.laojiang.diyview.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/6/13 9:06.
 */

public class PathEffectLayout extends View {

    public PathEffectLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(8);
        Path path = new Path();
        path.moveTo(15,60);
        for (int i = 0; i < 40; i++) {
            path.lineTo(i*30, (float) (Math.random()*150));
        }
        paint.setPathEffect(new CornerPathEffect(90));
        canvas.drawPath(path,paint);

        canvas.translate(40,100);
        paint.setPathEffect(new DashPathEffect(new float[]{20,8},1));
        canvas.drawPath(path,paint);
    }
}
