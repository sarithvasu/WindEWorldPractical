package com.effone.windeworldpractical.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.effone.windeworldpractical.data.HomeRepository
import com.effone.windeworldpractical.data.model.HomeFeed
import com.effone.windeworldpractical.data.model.ResponseCode

class HomeViewModel(private val homeRepository: HomeRepository): ViewModel() {
    private var _homeResult = MutableLiveData<HomeFeed>()
    val homeResult: LiveData<HomeFeed> = _homeResult

    fun getHomeFeed() {
        // can be launched in a separate asynchronous job
        homeRepository.getHomeData(
            homeResult as MutableLiveData<HomeFeed>
        )


    }
}