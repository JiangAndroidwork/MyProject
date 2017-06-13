package com.laojiang.myproject.ui;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.laojiang.myproject.R;
import com.laojiang.myproject.ui.fragment.FragmentTab1;
import com.laojiang.myproject.ui.fragment.FragmentTab2;
import com.laojiang.myproject.ui.fragment.FragmentTab3;
import com.laojiang.myproject.ui.fragment.FragmentTab4;
import com.laojiang.myproject.weight.SlideBackLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/5/11 9:19.
 */

public class FragmentPagerActivity extends AppCompatActivity {
    @BindView(R.id.framelayout)
    FrameLayout framelayout;
    @BindView(R.id.iv_tap1)
    ImageView ivTap1;
    @BindView(R.id.iv_tap2)
    ImageView ivTap2;
    @BindView(R.id.iv_tap3)
    ImageView ivTap3;
    @BindView(R.id.iv_tap4)
    ImageView ivTap4;
    private FragmentTransaction transaction;
    private FragmentTab1 fragmentTab1;
    private FragmentTab2 fragmentTab2;
    private FragmentTab3 fragmentTab3;
    private FragmentTab4 fragmentTab4;
    private SlideBackLayout slideBackLayout;
    private SlideBackLayout mSlideBackLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fragment_pager);
        ButterKnife.bind(this);
        mSlideBackLayout = new SlideBackLayout(this);
        mSlideBackLayout.bind();
        initView();
    }

    private void initView() {
        ConnectivityManager systemService = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
        if (activeNetworkInfo==null||!activeNetworkInfo.isConnected()){
            Log.i("网络状态===","没有网络");
        }else if (activeNetworkInfo!=null){
            switch (activeNetworkInfo.getType()) {
                case ConnectivityManager.TYPE_MOBILE:
                    Log.i("网络状态===", "移动网络");
                    break;
                case ConnectivityManager.TYPE_WIFI:
                    Log.i("网络状态===", "WIFI");
                    break;
            }
        }
        setNoSelect();
        ivTap1.setBackgroundResource(R.color.colorPrimary);
        if (null==fragmentTab1){
            fragmentTab1 = new FragmentTab1();
        }
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout,fragmentTab1);
        transaction.commit();
    }

    @OnClick({R.id.iv_tap1, R.id.iv_tap2, R.id.iv_tap3, R.id.iv_tap4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_tap1:
                setNoSelect();
                ivTap1.setBackgroundResource(R.color.colorPrimary);
                if (null==fragmentTab1){
                    fragmentTab1 = new FragmentTab1();
                }
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout,fragmentTab1);
                transaction.commit();
                break;
            case R.id.iv_tap2:
                setNoSelect();
                ivTap2.setBackgroundResource(R.color.colorPrimary);
                if (null== fragmentTab2){
                    fragmentTab2 = new FragmentTab2();
                }
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, fragmentTab2);
                transaction.commit();
                break;
            case R.id.iv_tap3:
                setNoSelect();
                ivTap3.setBackgroundResource(R.color.colorPrimary);
                if (null== fragmentTab3){
                    fragmentTab3 = new FragmentTab3();
                }
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, fragmentTab3);
                transaction.commit();
                break;
            case R.id.iv_tap4:
                setNoSelect();
                ivTap4.setBackgroundResource(R.color.colorPrimary);
                if (null== fragmentTab4){
                    fragmentTab4 = new FragmentTab4();
                }
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, fragmentTab4);
                transaction.commit();
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
