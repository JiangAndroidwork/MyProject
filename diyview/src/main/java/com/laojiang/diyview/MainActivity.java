package com.laojiang.diyview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.laojiang.diyview.weight.OpenItemLayout;
import com.laojiang.diyview.weight.PotterDufferLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView viewById;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initOpen();
    }

    private void initOpen() {

        OpenItemLayout openItemLayout = (OpenItemLayout) findViewById(R.id.openItem);
        openItemLayout.setTitle("标题");
        openItemLayout.setNumber("1");
        openItemLayout.setContent(R.layout.content_open);
    }

    public void initView(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.icon_2);
//        setBitmap(bitmap);
        PotterDufferLayout potterDufferLayout = new PotterDufferLayout(this);
    }

    private void setBitmap(Bitmap bitmap) {

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmap1 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);


        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);
        canvas.drawCircle(1000,1000,900,paint);
//
//        Rect rect  = new Rect(28,56,width,height);
//        RectF rectF = new RectF(rect);
//        canvas.drawRoundRect(rectF,80f,80f,paint);

        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        paint.setXfermode(porterDuffXfermode);
        canvas.drawBitmap(bitmap,80f,80f,paint);
        viewById.setImageBitmap(bitmap1);

    }
}

