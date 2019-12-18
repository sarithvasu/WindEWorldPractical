package com.effone.windeworldpractical.data

import androidx.lifecycle.MutableLiveData
import com.effone.windeworldpractical.data.model.HomeFeed
import com.effone.windeworldpractical.data.model.ResponseCode

class HomeRepository(val dataSource: HomeDataSource ){
    fun getHomeData(setResult: MutableLiveData<HomeFeed>): Result<MutableLiveData<HomeFeed>> {
        // handle login
        val result = dataSource.getHomeFeed(setResult)


        return result
    }
}