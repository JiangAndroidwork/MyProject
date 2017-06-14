package com.laojiang.diyview.interf

import android.view.View

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/6/14 8:06.
 */
interface OnItemListener {

    open fun onItemClickOpenListener(view: View,id:Int)
    open fun onItemClickCloseListener(view: View,id:Int)
}