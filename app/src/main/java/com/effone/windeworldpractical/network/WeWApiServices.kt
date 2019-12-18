package com.effone.windeworldpractical.network

import com.effone.windeworldpractical.data.model.HomeFeed
import com.effone.windeworldpractical.data.model.ResponseCode
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface WeWApiServices {
    @POST("access_token")
    fun userLogin(@Header("Accept") accept:String, @Header("Authorization") basicToken:String, @Header("Content-Type") content_type:String, @Query("grant_type") grantType:  String,@Query("username") username:  String,@Query("password") password:  String): Call<ResponseCode>

    @GET("/r/Android/new")
    fun getHomeFeed(@Header("Accept") accept:String, @Header("Authorization") OAuth:String, @Header("Content-Type") content_type:String): Call<HomeFeed>

}