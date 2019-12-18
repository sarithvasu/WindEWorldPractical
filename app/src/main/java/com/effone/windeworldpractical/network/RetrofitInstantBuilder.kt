package com.effone.windeworldpractical.network

import com.effone.windeworldpractical.common.WEWApi
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitInstantBuilder {


    var client = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30,TimeUnit.SECONDS)
        .build()
    var gson = GsonBuilder()
        .setLenient()
        .create()
    private val builder:Retrofit.Builder=Retrofit.Builder().baseUrl(WEWApi.BaseURL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
    private val retrofit:Retrofit= builder.build();

    fun <T> buildService(serviceType:Class<T>):T?{
       return retrofit.create(serviceType)
    }
}