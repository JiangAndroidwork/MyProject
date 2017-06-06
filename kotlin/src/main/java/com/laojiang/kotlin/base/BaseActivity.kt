package com.laojiang.kotlin.base

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

/**
 * 类介绍（必填）：基类
 * Created by Jiang on 2017/5/26 10:13.
 */
abstract class BaseActivity : AppCompatActivity(), View.OnClickListener {
    protected var mContentView: View? = null
    private var mHandler: Handler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            beforSetContentView(savedInstanceState)
        }
        if (mContentView == null)
            mContentView = layoutInflater.inflate(contentViewResId, null)
//        setContentView(mContentView)

        mHandler = Handler(mainLooper)
        initUI(mContentView!!)
        initData()
    }

     open protected  fun beforSetContentView(savedInstanceState: Bundle) {
    }
    /**
     * 添加点击监听到onClick()中
     */
    protected fun addClick(view: View?) {
        view?.setOnClickListener(this)
    }

    /**
     * 添加点击监听到onClick()中
     */
    protected fun addClick(id: Int) {
        val view = findViewById(id)
        addClick(view)
    }

    /**
     * 弹出Toast

     * @param resId 文字提示的资源id
     */
    open fun showShortToast(resId: Int) {
        mHandler!!.post { Toast.makeText(this@BaseActivity, resId, Toast.LENGTH_SHORT).show() }
    }

    /**
     * 弹出Toast

     * @param msg 文字提示的字符串
     */
    open  fun showShortToast(msg: String) {
        mHandler!!.post { Toast.makeText(this@BaseActivity, msg, Toast.LENGTH_SHORT).show() }
    }

    override fun onClick(v: View) {
        onClick(v, v.id)
    }
    inline fun Activity.toast(message:String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()

    }
    protected abstract val contentViewResId: Int

    protected abstract fun initUI(contentView: View)

    protected abstract fun initData()

    protected abstract fun onClick(v: View, id: Int)

}
