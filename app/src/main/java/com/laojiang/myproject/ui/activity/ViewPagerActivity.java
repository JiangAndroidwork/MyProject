package com.laojiang.myproject.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.laojiang.myproject.R;
import com.laojiang.myproject.adapter.ViewPagersAdapter;
import com.laojiang.myproject.view.PagerViewFour;
import com.laojiang.myproject.view.PagerViewOne;
import com.laojiang.myproject.view.PagerViewThree;
import com.laojiang.myproject.view.PagerViewTwo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/5/11 14:22.
 */

public class ViewPagerActivity extends AppCompatActivity {
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.iv_tap1)
    ImageView ivTap1;
    @BindView(R.id.iv_tap2)
    ImageView ivTap2;
    @BindView(R.id.iv_tap3)
    ImageView ivTap3;
    @BindView(R.id.iv_tap4)
    ImageView ivTap4;
    private ViewPagersAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        ButterKnife.bind(this);
        setNoSelect();
        ivTap1.setBackgroundResource(R.color.colorPrimary);
        initView();
    }

    private void initView() {
        PagerViewOne pagerView1 = new PagerViewOne(this);
        PagerViewTwo pagerView2 = new PagerViewTwo(this);
        PagerViewThree pagerView3 = new PagerViewThree(this);
        PagerViewFour pagerView4 = new PagerViewFour(this);

        List<View> viewList = new ArrayList<>();
        viewList.add(pagerView1.getPageView1());
        viewList.add(pagerView2.getPageView1());
        viewList.add(pagerView3.getPageView1());
        viewList.add(pagerView4.getPageView1());
        adapter = new ViewPagersAdapter(viewList);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setNoSelect();

                switch (position){
                    case 0:
                        ivTap1.setBackgroundResource(R.color.colorPrimary);
                        break;
                    case 1:
                        ivTap2.setBackgroundResource(R.color.colorPrimary);
                        break;
                    case 2:
                        ivTap3.setBackgroundResource(R.color.colorPrimary);
                        break;
                    case 3:
                        ivTap4.setBackgroundResource(R.color.colorPrimary);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick({R.id.iv_tap1, R.id.iv_tap2, R.id.iv_tap3, R.id.iv_tap4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_tap1:
                setNoSelect();
                viewPager.setCurrentItem(0);
                ivTap1.setBackgroundResource(R.color.colorPrimary);
                break;
            case R.id.iv_tap2:
                setNoSelect();
                ivTap2.setBackgroundResource(R.color.colorPrimary);
                viewPager.setCurrentItem(1);
                break;
            case R.id.iv_tap3:
                setNoSelect();
                ivTap3.setBackgroundResource(R.color.colorPrimary);
                viewPager.setCurrentItem(2);
                break;
            case R.id.iv_tap4:
                setNoSelect();
                ivTap4.setBackgroundResource(R.color.colorPrimary);
                viewPager.setCurrentItem(3);
                break;
        }
    }
    private void setNoSelect() {
        ivTap1.setBackgroundResource(R.color.colorAccent);
        ivTap2.setBackgroundResource(R.color.colorAccent);
        ivTap3.setBackgroundResource(R.color.colorAccent);
        ivTap4.setBackgroundResource(R.color.colorAccent);

    }
}
