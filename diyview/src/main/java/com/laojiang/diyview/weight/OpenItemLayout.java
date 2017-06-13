package com.laojiang.diyview.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.laojiang.diyview.R;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/6/13 10:22.
 */

public class OpenItemLayout extends LinearLayout {
    private int widthMeasureSpec;
    private int heightMeasureSpec;
    private Context context;
    private TextView tvNumber;
    private TextView tvTitle;
    private RelativeLayout rlContent;
    private RelativeLayout rlTitle;
    private boolean isClose = true;
    private ImageView ivJiantou;
    private int imageId;
    private ImageView imageView;
    private int titleBackGround;

    public OpenItemLayout(Context context) {
        super(context);
        this.context = context;
    }

    public OpenItemLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        //自定义属性
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.myView);
        titleBackGround = ta.getColor(R.styleable.myView_titleBackground, getResources().getColor(R.color.color_1));

        LayoutInflater.from(context).inflate(R.layout.linearlayout_open,this);
        init();
        ta.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.widthMeasureSpec = widthMeasureSpec;
        this.heightMeasureSpec = heightMeasureSpec;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    private void init() {
        rlTitle = (RelativeLayout) findViewById(R.id.rl_title);
        tvNumber = (TextView) findViewById(R.id.tv_number);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        ivJiantou = (ImageView) findViewById(R.id.iv_jiantou);
        rlContent = (RelativeLayout) findViewById(R.id.rl_content);
        setTitleListener();
        rlTitle.setBackgroundColor(titleBackGround);
    }
  public void  setNoListener(){
      if (rlTitle!=null)
          rlTitle.setOnClickListener(null);

    }
    public  void setTitleListener() {
        rlTitle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateArrow();
            }
       });
    }

    public  void rotateArrow(){
        int degree = 0;
        if (ivJiantou.getTag()==null||ivJiantou.getTag().equals(true)){
            ivJiantou.setTag(false);
            degree = -180;
            if (rlContent!=null&&imageView!=null){
                rlContent.addView(imageView);
            }
            expend(rlContent);

        }else if (ivJiantou.getTag().equals(false)){
            Log.i("执行关闭","执行了");
            degree = 0;
            ivJiantou.setTag(true);
            closeContent(rlContent);
        }
        ivJiantou.animate().setDuration(300).rotation(degree);
    }
    private void expend(final View v) {
        v.measure(widthMeasureSpec,heightMeasureSpec);
        int measuredWidth = v.getMeasuredWidth();
        final int measuredHeight = v.getMeasuredHeight();
        v.setVisibility(VISIBLE);
        //首先设置 布局的高度为0避免有闪烁
        LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ll.height  = 0;
        v.setLayoutParams(ll);
        Animation animation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime==1){
                    v.getLayoutParams().height = measuredHeight;

                }else {
                    v.getLayoutParams().height = (int) (measuredHeight*interpolatedTime);
                }
                v.requestLayout();
            }
            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };
        animation.setDuration(300);
        v.startAnimation(animation);
    }

    public void closeContent(final View v){
        final int measuredHeight = v.getMeasuredHeight();
        Animation animation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime==1){
                    v.setVisibility(GONE);
                    if (rlContent!=null){
                        rlContent.removeAllViews();
                    }
                }else {
                    v.getLayoutParams().height = measuredHeight-(int) (measuredHeight*interpolatedTime);
                    v.requestLayout();
                }

            }
            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };
        animation.setDuration(300);
        v.startAnimation(animation);


    }

    //打开
    private void openContent() {
        Log.i("被执行","动画效果");
        ivJiantou.animate().setDuration(300).rotation(180).start();
    }

    /**
     * 设置数字
     *
     * @param number
     */
    public void setNumber(String number) {
        tvNumber.setText(number == null ? "" : number);
    }

    public void setTitle(String title) {
        tvTitle.setText(title == null ? "" : title);
    }

    public void setContent(int contentId) {
        View viewContent = View.inflate(context, contentId, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        viewContent.setLayoutParams(layoutParams);
        rlContent.addView(viewContent);
    }
    public void setImage(int imageId){
        imageView = new ImageView(context);

        imageView.setImageResource(imageId);
    }

}
