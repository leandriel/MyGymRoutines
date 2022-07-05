package com.leandroid.system.mygymroutines.ui.view.signin

import androidx.lifecycle.ViewModel
import com.leandroid.system.mygymroutines.data.repository.auth.AuthRepository

class SignInViewModel(private val repository: AuthRepository): ViewModel() {
    fun login(email: String, pass: String ){
        repository.login(email, pass)
    }
}