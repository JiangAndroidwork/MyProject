package com.laojiang.kotlin.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.laojiang.kotlin.R

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/5/22 14:03.
 */
class PriseKotlinAdapter(private val context: Context, private val list: List<String>?) : BaseAdapter() {

    override fun getCount(): Int {
        if (list == null)
            return 0
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        val view = View.inflate(context, R.layout.item_listview, null)
        val test = view.findViewById(R.id.tv_test) as TextView
        test.text = list!![position]
        return view
    }
}
