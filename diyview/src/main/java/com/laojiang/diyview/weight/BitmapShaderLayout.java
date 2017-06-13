package com.laojiang.diyview.weight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.laojiang.diyview.R;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/6/13 8:26.
 */

public class BitmapShaderLayout extends ImageView {
    public BitmapShaderLayout(Context context) {
        super(context);
    }

    public BitmapShaderLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon_3);
//        BitmapShader shader  = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        int[] colors = new int[]{R.color.color_1, R.color.color_2, R.color.color_3, R.color.color_4, R.color.color_5, R.color.color_6};
        SweepGradient sweepGradient = new SweepGradient(200, 200, colors, null);
        paint.setShader(sweepGradient);
        canvas.translate(250, 430);
        canvas.drawCircle(200, 200, 500, paint);

    }
}
