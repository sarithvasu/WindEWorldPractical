package com.effone.windeworldpractical.data

import androidx.lifecycle.MutableLiveData
import com.effone.windeworldpractical.common.WEWApi
import com.effone.windeworldpractical.data.model.HomeFeed
import com.effone.windeworldpractical.data.model.ResponseCode
import com.effone.windeworldpractical.network.RetrofitInstantBuilder
import com.effone.windeworldpractical.network.WeWApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeDataSource {

    val token ="bearer ${WEWApi.AcessToken}"
    fun getHomeFeed(setResult:MutableLiveData<HomeFeed>): Result<MutableLiveData<HomeFeed>>{
        val homeFeedService = RetrofitInstantBuilder.buildService(WeWApiServices::class.java)
        homeFeedService?.getHomeFeed(
            "application/JSON",
            token,
            "application/JSON"
        ).also {
            it?.enqueue(object : Callback<HomeFeed> {
                override fun onFailure(call: Call<HomeFeed>, t: Throwable) {
                    val s = "sss"
                }

                override fun onResponse(
                    call: Call<HomeFeed>,
                    response: Response<HomeFeed>
                ) {
                    if (response.isSuccessful) {
                        setResult.value=response.body()


                    }
                }

            })
        }
        return Result.Success(setResult)
    }
}