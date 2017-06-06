package cn.laojiang.kotlin.bean

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/6/5 14:17.
 */
class Person {
    var name:String?=null
    var age:Int = 0
    operator fun component1(): Any {
        return name!!
    }
    operator fun component2(): Any {
        return age
    }
}