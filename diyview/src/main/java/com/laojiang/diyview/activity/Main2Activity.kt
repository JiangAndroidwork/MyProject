package com.laojiang.diyview.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.laojiang.diyview.R
import com.laojiang.diyview.bean.MyGirlBean
import com.laojiang.diyview.weight.OpenItemLayout
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.item_adapter_open.view.*

class Main2Activity : AppCompatActivity() {
    var list = ArrayList<MyGirlBean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        iniData()
        initView()

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

        for (i in 0..20) {
            var view = View.inflate(this, R.layout.item_adapter_open, null)
            var openLayout:OpenItemLayout = view.adapter_openItem
            openLayout!!.setNumber("${i+1}")
            openLayout!!.setTitle(list.get(i).title)
            openLayout!!.setImage(list.get(i).contentId)
            ll_content.addView(view)
        }

    }

    private fun otherNo() {


    }
}
