package com.effone.windeworldpractical.common

import android.content.Context
import android.content.SharedPreferences

class Preference(val context: Context) {

    private var sharedRef: SharedPreferences? = null
    private var userBasicInfo: HashMap<String, Int> = HashMap()

    init {
        this.sharedRef = context.getSharedPreferences(Utility.WEW_PREFERENCE, Context.MODE_PRIVATE)
    }

     fun saveAcessToken(token: String) {
        val editor = sharedRef!!.edit()
        editor.putString(Utility.ACCESS_TOKEN, token)
        editor.apply()
    }


    fun getAcessToken() : String? {
        return  sharedRef!!.getString(Utility.ACCESS_TOKEN, "")
    }








}







