package com.effone.windeworldpractical.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.effone.windeworldpractical.data.HomeDataSource
import com.effone.windeworldpractical.data.HomeRepository
import com.effone.windeworldpractical.data.LoginDataSource
import com.effone.windeworldpractical.data.LoginRepository
import com.effone.windeworldpractical.ui.login.LoginViewModel

class HomeViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(
                homeRepository = HomeRepository(
                    dataSource = HomeDataSource()
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}