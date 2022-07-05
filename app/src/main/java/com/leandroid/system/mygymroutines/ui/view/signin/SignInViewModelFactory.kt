package com.leandroid.system.mygymroutines.ui.view.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.leandroid.system.mygymroutines.data.repository.auth.AuthRepository

class SignInViewModelFactory(private val repository: AuthRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(AuthRepository::class.java)
            .newInstance(repository)
    }
}