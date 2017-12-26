package com.smeiling.multibanner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.my_view.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var banners = mutableListOf<BannerItem>()

        var banner = BannerItem()
        banner.imageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514312635113&di=659020a33fae76ab2535d0eb80ef9ad0&imgtype=0&src=http%3A%2F%2Fpic77.nipic.com%2Ffile%2F20150914%2F19016015_153803898496_2.jpg"
        banners.add(banner)
        var banner2 = BannerItem()
        banner.imageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514312179654&di=f8c61d364261427ad808fabe5a7f21f1&imgtype=0&src=http%3A%2F%2Fpic2.ooopic.com%2F01%2F15%2F66%2F71b1OOOPIC48.jpg"
        banners.add(banner2)

        var view = LayoutInflater.from(baseContext).inflate(R.layout.my_view, null)
        view.btn.setOnClickListener {
            Toast.makeText(baseContext, "MyBtn clicked!!!", Toast.LENGTH_SHORT).show()
        }
        var banner3 = BannerItem()
        banner.childView = view
        banners.add(banner3)
        ad_banner.setItems(banners)

    }
}
