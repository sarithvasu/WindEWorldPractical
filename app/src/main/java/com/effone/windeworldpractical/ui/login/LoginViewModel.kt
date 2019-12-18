package com.effone.windeworldpractical.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import com.effone.windeworldpractical.data.LoginRepository
import com.effone.windeworldpractical.data.Result

import com.effone.windeworldpractical.R
import com.effone.windeworldpractical.data.model.ResponseCode

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private var _loginResult = MutableLiveData<ResponseCode>()
    val loginResult: LiveData<ResponseCode> = _loginResult

    fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
         loginRepository.login(username, password,
            loginResult as MutableLiveData<ResponseCode>
        )


    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}
