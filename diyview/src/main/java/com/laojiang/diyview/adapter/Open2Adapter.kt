package com.laojiang.diyview.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.laojiang.diyview.R
import com.laojiang.diyview.bean.MyGirlBean
import com.laojiang.diyview.weight.OpenItemLayout

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/6/13 13:58.
 */
class OpenA2dapter(var context:Context,var list:List<MyGirlBean>) : BaseAdapter() {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = View.inflate(context, R.layout.item_adapter_open, null)
        var openItem = view.findViewById(R.id.adapter_openItem) as OpenItemLayout
     openItem!!.setNumber("$position")
        openItem!!.setTitle(list.get(position).title)
//        viewHolder.openItem!!.setContent(list.get(position).contentId)
       openItem!!.setImage(list.get(position).contentId)

        return view
    }

    override fun getItem(position: Int): Any {
        return list.get(position)
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
    private class ViewHolder(var view:View){
        var openItem: OpenItemLayout? = null
    }
}