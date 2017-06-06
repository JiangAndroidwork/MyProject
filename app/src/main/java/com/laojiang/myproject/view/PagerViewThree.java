package com.laojiang.myproject.view;

import android.content.Context;
import android.view.View;

import com.laojiang.myproject.R;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/5/11 16:11.
 */

public class PagerViewThree extends View {
    private View pageView1;
    public PagerViewThree(Context context) {
        super(context);
        pageView1 = View.inflate(context, R.layout.pager_3,null);
    }

    public View getPageView1() {
        return pageView1;
    }
}
