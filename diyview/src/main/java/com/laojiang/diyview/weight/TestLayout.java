package com.laojiang.diyview.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * 类介绍（必填）：自定义控件 ： 自动换行
 * Created by Jiang on 2017/6/14 13:15.
 */

public class TestLayout extends ViewGroup {
    int verticalSpacing = 20;
    public TestLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);



        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();

    //已经被占用的长度
        int withUsed =  paddingLeft+paddingRight;
        int heightUsed = paddingTop +paddingBottom;

        int childMaxHeightOfThisLine = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);//获取单个的子view
            if (child.getVisibility()!=GONE) {
                int childWithUsed = 0;
                int childHeightUsed = 0;
                measureChild(child,widthMeasureSpec,heightMeasureSpec);

                childWithUsed += child.getMeasuredWidth();
                childHeightUsed += child.getMeasuredHeight();

//                LayoutParams childLayoutParams = child.getLayoutParams();
//                MarginLayoutParams marginLayoutParams  = (MarginLayoutParams) childLayoutParams;

                ViewGroup.LayoutParams params = child.getLayoutParams();
                ViewGroup.MarginLayoutParams marginParams = null;
                //获取view的margin设置参数
                if (params instanceof ViewGroup.MarginLayoutParams) {
                    marginParams = (ViewGroup.MarginLayoutParams) params;
                } else {
                    //不存在时创建一个新的参数
                    //基于View本身原有的布局参数对象
                    marginParams = new ViewGroup.MarginLayoutParams(params);
                }
                    childWithUsed +=marginParams.leftMargin+marginParams.rightMargin;
                childHeightUsed +=marginParams.topMargin+marginParams.bottomMargin;
                if (withUsed+childWithUsed<widthSize){
                    //不需要换行
                    withUsed += childWithUsed;
                    //是否需要更新高
                    if (childHeightUsed>childMaxHeightOfThisLine){
                        childMaxHeightOfThisLine = childHeightUsed;

                    }

                }else {
                    //处理换行
                    //增加view的高
                    heightUsed += childMaxHeightOfThisLine+verticalSpacing;
                    //重新计算宽度
                    withUsed = paddingLeft+paddingRight+childWithUsed;
                    //换行之后第一个控件的高是行高
                    childMaxHeightOfThisLine = childHeightUsed;
                }
            }
        }
        heightUsed += childMaxHeightOfThisLine;
        setMeasuredDimension(widthSize,heightUsed);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();

        int childStartLayoutX = paddingLeft;
        int childStartLayoutY = paddingTop;

        int widthUsed  = paddingLeft+paddingRight;
        int heightUsed = paddingTop+paddingBottom;

        int childMaxHeight = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility()!=GONE){
                int childNeedeWidth,childNeedHeight;
                int left,top,right,bottom;

                int childMeasureWith = childAt.getMeasuredWidth();
                int childMeasureHeight = childAt.getMeasuredHeight();

//                LayoutParams childAtLayoutParams = childAt.getLayoutParams();
//                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAtLayoutParams;
                ViewGroup.LayoutParams params = childAt.getLayoutParams();
                ViewGroup.MarginLayoutParams marginParams = null;
                //获取view的margin设置参数
                if (params instanceof ViewGroup.MarginLayoutParams) {
                    marginParams = (ViewGroup.MarginLayoutParams) params;
                } else {
                    //不存在时创建一个新的参数
                    //基于View本身原有的布局参数对象
                    marginParams = new ViewGroup.MarginLayoutParams(params);
                }
                int childLeftMargin= marginParams.leftMargin;
                int childRightMargin = marginParams.rightMargin;
                int childTopMargin  = marginParams.topMargin;
                int childBottomMargin = marginParams.bottomMargin;

                childNeedeWidth = childLeftMargin+childRightMargin+childMeasureWith;
                childNeedHeight = childTopMargin +childBottomMargin+childMeasureHeight;

                if (widthUsed+childNeedeWidth<=r-1){
                    if (childNeedHeight>childMaxHeight){
                        childMaxHeight = childNeedHeight;
                    }
                    left = childStartLayoutX+childLeftMargin;
                    top = childStartLayoutY+childTopMargin;
                    right = left+childMeasureWith;
                    bottom = top+childMeasureHeight;
                    widthUsed +=childNeedeWidth;
                    childStartLayoutX += childNeedeWidth;
                }else {
                    childStartLayoutY +=childMaxHeight+verticalSpacing;
                    childStartLayoutX = paddingLeft;
                    widthUsed  =paddingLeft+paddingRight;
                    left = childStartLayoutX +childLeftMargin;
                    top = childStartLayoutY +childTopMargin;
                    right =left+childMeasureWith;
                    bottom = top+childMeasureHeight;

                    widthUsed +=childNeedeWidth;
                    childStartLayoutX +=childNeedeWidth;
                    childMaxHeight = childNeedHeight;
                }
                childAt.layout(left,top,right,bottom);
            }
        }

    }


}
