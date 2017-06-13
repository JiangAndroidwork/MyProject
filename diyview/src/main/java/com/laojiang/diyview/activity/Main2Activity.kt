package com.laojiang.diyview.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.laojiang.diyview.R
import com.laojiang.diyview.adapter.OpenAdapter
import com.laojiang.diyview.bean.MyGirlBean
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initView()
    }

    private fun initView() {
        var list = ArrayList<MyGirlBean>()
        for (i in 1..50){
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
        var adapter = OpenAdapter(this,list)
        list_view.adapter =adapter

    }
}
