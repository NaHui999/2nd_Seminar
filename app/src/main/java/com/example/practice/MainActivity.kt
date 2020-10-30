package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var RecyclerAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RecyclerAdapter = RecyclerAdapter(this)

        main_rcv.adapter = RecyclerAdapter
        main_rcv.layoutManager = LinearLayoutManager(this) //이 레이아웃을 격자형으로든 바꿀 수 있다.

        RecyclerAdapter.data = mutableListOf(
                RecyclerData("이름","나희정","2020/10/1","이름에 대한 자세한 설명"),
                RecyclerData("나이","22","2020/10/2","나이에 대한 자세한 설명"),
                RecyclerData("파트","안드로이드","2020/10/3","파트에 대한 자세한 설명"),
                RecyclerData("GitHub","www.github.com/nahui999","2020/10/4","깃헙에 대한 자세한 설명"),
                RecyclerData("Blog","None","2020/10/5","블로그에 대한 자세한 설명"),
                RecyclerData("Sopt","www.sopt.org","2020/10/6","솝트에 대한 자세한 설명")
        )
        RecyclerAdapter.notifyDataSetChanged()

    }
}