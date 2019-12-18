package com.effone.windeworldpractical.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.effone.windeworldpractical.R
import com.effone.windeworldpractical.data.model.Children
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val homeViewModel=ViewModelProvider(this,HomeViewModelFactory()).get(HomeViewModel::class.java)
        homeViewModel.getHomeFeed()
        homeViewModel.homeResult.observe(this@HomeActivity, Observer {
            rv_home_feed.apply {
                adapter=HomeFeedAdapterclass(this@HomeActivity,
                    it.data.children as ArrayList<Children>
                )
            }
        })
    }
}
