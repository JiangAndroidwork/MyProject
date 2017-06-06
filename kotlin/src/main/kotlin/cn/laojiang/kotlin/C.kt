package cn.laojiang.kotlin

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/6/1 15:21.
 */
class C() : A(), B {
    var l: Int = 0
    private fun setDataFromString(value: Int) {
        l = value
    }

    constructor(int: Int) : this() {
        super.num = int
    }

    override var num: Int
        get() = super.num
        set(value) {
        }
    override var nums: Int
        get() = 123 //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}
    override var str: String
        get() = "jiang" //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

    override fun f() {
        super<A>.f()
        super<B>.f()
    }
}