package cn.laojiang.kotlin

import android.util.Log

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/5/19 10:05.
 */
public  class PriseKotlin(){


public fun openSet(vararg strArray:String){
      Log.i("输出==",strArray[0])

}
    //动态代理
    interface Animal{
        fun bark():String
    }
    class Dog:Animal{

        override fun bark():String {
           return "狗"
        }
        fun dogName(){

        }
    }
    class Cat(animal: Animal):Animal by animal{

    }
    //lambda
    var str = {s:String,b:String ->s+b}("abc","还有谁")
    fun getString(s:String,q:String):String ={
        a:String,b:String->a+b
    }(s,q)

}