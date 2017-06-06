package com.laojiang.kotlin.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.laojiang.kotlin.R;

import java.util.List;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/5/22 13:58.
 */

public class PriseAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;

    public PriseAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        if (list==null)
            return 0;
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.item_listview, null);
        TextView test = (TextView) view.findViewById(R.id.tv_test);
        test.setText(list.get(position));
        return view;
    }
}
