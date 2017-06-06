package com.laojiang.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.laojiang.myproject.ui.FragmentPagerActivity;
import com.laojiang.myproject.ui.activity.ViewPagerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bt_fragment)
    Button btFragment;
    @BindView(R.id.bt_viewPager)
    Button btViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_fragment, R.id.bt_viewPager})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_fragment:
                Intent intent = new Intent(this, FragmentPagerActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.base_slide_right_in, R.anim.base_slide_right_out);
                break;
            case R.id.bt_viewPager:
                Intent intent1 = new Intent(this,ViewPagerActivity.class);
                startActivity(intent1);

                break;
        }
    }

}
