package com.laojiang.kotlin

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import cn.laojiang.kotlin.bean.Person
import com.laojiang.imagepickers.ImagePicker
import com.laojiang.imagepickers.data.ImageBean
import com.laojiang.imagepickers.data.ImagePickType
import com.laojiang.imagepickers.utils.GlideImagePickerDisplayer
import com.laojiang.kotlin.adapter.Adapter
import com.laojiang.kotlin.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main2.*
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.async
import java.io.File

class Main2Activity : BaseActivity() {
    private val REQUEST_CODE = 101
    private val RESULT_CODE = 202

    override fun onClick(v: View, id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val contentViewResId: Int
        get() = R.layout.activity_main2

    override fun initData() {
    }

    var str = { a: String, b: String -> a + b }


    override fun beforSetContentView(savedInstanceState: Bundle) {
        super.beforSetContentView(savedInstanceState)

    }
    override fun initUI(mContentView: View) {
        val person = Person()

    }
    fun asyncPrise(){
        async {  }
    }
    fun alert(){
        alert("弹窗内容"){

            yesButton{
                toast("确定按钮")
            }
            noButton{toast("取消按钮")}
        }.show()
    }
    fun prise1(){
        val(name,age) = Person()
        Log.i("数据解构==",name.toString()+"\n"+age.toString())
    }
    private fun setView() {

        verticalLayout {

            padding = dip(16)
            val tvName = textView("设置按钮"){

                onClick { showShortToast("1111") }
            } .lparams {
                width= wrapContent
                height = wrapContent
                horizontalMargin=40
            }
            val button = button("还有谁"){

            }.lparams{
                width= px2dip(100).toInt()
                height = px2dip(40).toInt()

            }
        }
    }

    fun demo1(num:Int){
        when(num){
           0 -> Log.i("结果===","是0")
            else -> Log.i("结果===","不是0")
        }
    }
    /**
     * 图片选择器
     */
    fun initPhoto() {
        var cachePath = Environment.getExternalStorageDirectory().toString() + "/bjhj/file/"
        val file = File(cachePath)
        if (!file.exists()) {
            file.mkdir()
        }
        val build = ImagePicker.Builder()
                .pickType(ImagePickType.MUTIL)
                .maxNum(9)
                .needCamera(true)
                .cachePath(cachePath)
                .displayer(GlideImagePickerDisplayer())
                .build()
        build.start(this, REQUEST_CODE, RESULT_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_CODE && data != null) {
            val dataList = data.getParcelableArrayListExtra<ImageBean>(ImagePicker.INTENT_RESULT_DATA)
            Log.i("收到的数据结果===", dataList.toString())
        }
    }

    fun initView() {
        var list: List<String> = listOf("是的", "好吧", "没办法")
        var adapters = Adapter(this, list)
        lv_data!!.adapter = adapters
        showShortToast("完成")
    }

    /**
     * max(23,{ demoJava()}).toString()
     */
    fun max(int: Int, sum: () -> List<Int>): Boolean {
        if (int in sum()) {
            return true
        } else {
            return false
        }
    }

    private fun demoJava(): List<Int> {
        var list = ArrayList<Int>()
        for (num in 1..10) {
            list.add(num)
        }
        return list
    }

    private fun downTo() {
        for (num in 10 downTo 0 step 2) {
            Log.i("结果==", "$num")
        }
    }

    private fun getNum() {
        for (num in 1..10 step 2) {
            Log.i("结果==", "$num")
        }
    }

    private fun demoRange() {
        var result = listOf<Int>()
        for (num in 1..5) {
            Log.i("结果==", "$num")
        }
    }

    private fun getBooleanNum(num: Int): String = when (num) {
        in 1..20 -> "在1-20之间"
        else -> "没有再1-20之间"
    }

    private fun demoFOR2() {
        val items = listOf("123", "dsf", "324")
        for (num in items.indices) {
            Log.i("遍历--", "第${num}个是${items[num]}")
        }
    }

    private fun describe(obj: Any): String = when (obj) {
        "aaa" -> "sdf"
        "bbb" -> "dsa"
        else -> "没有满足"
    }

    private fun demoFOR() {
        val items = listOf("app", "ddff", "11")
        for (t in items) {
            Log.i("集合", "$t")
        }
    }

    private fun strToInt(str: String): Int {
        return str.toInt() + 2
    }


    /**
     *
     */
    private fun getNum(a: Int, b: Int): Int {
        return a + b;
    }


}

