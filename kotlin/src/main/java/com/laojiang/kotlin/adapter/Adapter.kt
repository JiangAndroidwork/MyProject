package com.laojiang.kotlin.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.laojiang.kotlin.R

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/5/22 13:23.
 */
  class Adapter: BaseAdapter {
    val context:Context
    var list:List<String>
    constructor(context:Context, list: List<String>)  {
        this.context = context
        this.list = list
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View = View.inflate(context, R.layout.item_listview,null)
        val test = view.findViewById(R.id.tv_test) as TextView
        test.text=list!![position]
        return view
    }

    override fun getItem(position: Int): Any {
        return list!![position]

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        if (list==null)
            return 0
        else
            return list.size
    }
}