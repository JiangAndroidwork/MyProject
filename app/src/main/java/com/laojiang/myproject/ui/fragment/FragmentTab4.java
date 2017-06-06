package com.laojiang.myproject.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laojiang.myproject.R;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/5/11 11:06.
 */

public class FragmentTab4 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabtfour,container,false);
        return view;

    }
}
