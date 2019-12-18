package com.effone.windeworldpractical.data

import androidx.lifecycle.MutableLiveData
import com.effone.windeworldpractical.data.model.LoggedInUser
import com.effone.windeworldpractical.data.model.ResponseCode

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(val dataSource: LoginDataSource) {

    // in-memory cache of the loggedInUser object
    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

    fun logout() {
        user = null
        dataSource.logout()
    }

    fun login(username: String, password: String,setResult:MutableLiveData<ResponseCode>): Result<MutableLiveData<ResponseCode>> {
        // handle login
        val result = dataSource.login(username, password,setResult)


        return result
    }


}
