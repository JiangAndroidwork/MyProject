package cn.laojiang.kotlin

/**
 * 类介绍（必填）：单例
 * Created by Jiang on 2017/5/26 15:00.
 */
class Single private constructor(){
    var name:String ="姓名"
    var age:Int = 10

    companion object{
        fun get():Single{
            return Holder.instance
        }
    }
    private object Holder{
        val  instance = Single()
    }

}