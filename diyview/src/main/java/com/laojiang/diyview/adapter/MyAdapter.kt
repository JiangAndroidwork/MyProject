package com.laojiang.diyview.adapter

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.laojiang.diyview.R
import com.laojiang.diyview.bean.MyGirlBean
import com.laojiang.diyview.utils.adapterpacking.MyBaseAdapter
import com.laojiang.diyview.utils.adapterpacking.ViewHolder
import com.laojiang.diyview.weight.OpenItemLayout

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/6/13 16:19.
 */
class MyAdapter(context: Context, list: List<MyGirlBean>): MyBaseAdapter<MyGirlBean>(context, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder = ViewHolder.get(context, convertView, parent, R.layout.item_adapter_open, position)
        var openLayout:OpenItemLayout = holder.getView(R.id.adapter_openItem)
        openLayout!!.setNumber("$position")
        val bean:MyGirlBean = list.get(position)
        openLayout!!.setTitle(bean.title)
        openLayout!!.setImage(bean.contentId)
        Log.i("点击的位置====",position.toString())
        return holder.convertView
    }
}