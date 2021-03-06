package com.laojiang.diyview.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import com.laojiang.diyview.R
import com.laojiang.diyview.bean.MyGirlBean
import com.laojiang.diyview.interf.OnItemListener
import com.laojiang.diyview.weight.OpenItemLayout
import com.laojiang.diyview.weight.TestLayout
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.item_adapter_open.view.*
import java.util.*

class Main2Activity : AppCompatActivity(), OnItemListener {



    var list = ArrayList<MyGirlBean>()
    var listId =ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //扩展条目
//        iniData()
//        initView()
        //
        init1();

    }

    private fun init1() {
        var testLayout: TestLayout = test_layout
        val strs = arrayOf("你想咋地","真是不错","哈哈哈","6","真是漂亮极了")
        var random = Random()

        iv_image.setOnClickListener {
            var i = random.nextInt(5)
            var text = TextView(this)
            text.text = strs[i]
            text.textSize = 17f
            text.requestLayout()


            text.setBackgroundResource(R.drawable.shape_text_bg)
            testLayout.addView(text)
        }

    }

    private fun iniData() {

        for (i in 0..21){
            var bean = MyGirlBean()
            when(i){
                1 ->bean.contentId = R.drawable.girl_1
                2 ->bean.contentId = R.drawable.girl_2
                3 ->bean.contentId = R.drawable.girl_3
                4 ->bean.contentId = R.drawable.girl_4
                5 ->bean.contentId = R.drawable.girl_5
                6 ->bean.contentId = R.drawable.girl_6
                7 ->bean.contentId = R.drawable.girl_7
                8 ->bean.contentId = R.drawable.girl_8
                9 ->bean.contentId = R.drawable.girl_9
                10 ->bean.contentId = R.drawable.girl_10
                else ->bean.contentId = R.drawable.girl_10
            }
            bean.title = "我的女友$i"
            list.add(bean)
        }
    }
    private fun initView() {
        for (i in list.indices) {
            var view = View.inflate(this, R.layout.item_adapter_open, null)
            var openLayout:OpenItemLayout = view.adapter_openItem
            openLayout!!.setNumber("${i+1}")
            openLayout!!.setTitle(list.get(i).title)
            openLayout!!.setImage(list.get(i).contentId)
            openLayout.id = "110$i".toInt()
            openLayout.setOnItemClickListener(this,"110$i".toInt())
//            ll_content.addv(view)
        }
    }

    override fun onItemClickOpenListener(view: View, id: Int) {
        Log.i("执行打开接口===",id.toString())
    }
    override fun onItemClickCloseListener(view: View, id: Int) {
        Log.i("执行关闭接口===",id.toString())
    }
}


