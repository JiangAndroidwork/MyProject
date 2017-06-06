package cn.laojiang.kotlin

/**
 * 类介绍（必填）：lambda
 * Created by Jiang on 2017/6/5 9:14.
 */
class PriseLambda {
    val str = {s:String,b:String->s+b}
    inline fun demo(ss:(String,String)->String):String{
        return ss("34","sf")
    }
}