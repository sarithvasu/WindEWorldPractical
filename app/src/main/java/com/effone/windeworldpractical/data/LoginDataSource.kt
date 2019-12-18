package com.effone.windeworldpractical.data

import android.util.Base64
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.effone.windeworldpractical.common.Preference
import com.effone.windeworldpractical.data.model.LoggedInUser
import com.effone.windeworldpractical.data.model.ResponseCode
import com.effone.windeworldpractical.network.RetrofitInstantBuilder
import com.effone.windeworldpractical.network.WeWApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String,setResult:MutableLiveData<ResponseCode>): Result<MutableLiveData<ResponseCode>> {
        // adjustLoginlayout(false);
        val value = "sG7WikFP8UbFlQ:9NwUSuG3IZf-pJKoQ-vp8oWAZqs"
        val token = "Basic " + String(Base64.encode(value.toByteArray(), Base64.NO_WRAP))
        val loginService = RetrofitInstantBuilder.buildService(WeWApiServices::class.java)
        loginService?.userLogin(
            "application/JSON",
            token,
            "application/JSON", "password",username,password
        ).also {
            it?.enqueue(object : Callback<ResponseCode> {
                override fun onFailure(call: Call<ResponseCode>, t: Throwable) {
                    val s = "sss"
                }

                override fun onResponse(
                    call: Call<ResponseCode>,
                    response: Response<ResponseCode>
                ) {
                    if (response.isSuccessful) {
                        setResult.value=response.body()


                    }
                }

            })
        }
        return Result.Success(setResult)
    }

    fun logout() {
        // TODO: revoke authentication
    }
}

