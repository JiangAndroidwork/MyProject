package cn.laojiang.kotlin

import android.util.Log

/**
 * 类介绍（必填）：for循环
 * Created by Jiang on 2017/6/1 8:59.
 */
class PriseOfFor {
    internal var s = intArrayOf(234, 3424, 234)
    var lt = listOf<Int>(213,32,11,31)
    fun getNum(list:Any){
        for (num:Int in s){
            Log.i("打印结果==",num.toString())
        }
    }
    fun demo1(){
        for (i in lt.indices){
            Log.i("打印结果===",lt[i].toString())
        }
    }
}