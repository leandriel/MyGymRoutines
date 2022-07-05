package com.leandroid.system.mygymroutines.data.repository.auth

import com.leandroid.system.mygymroutines.data.network.FirebaseSignInManager

class AuthRepository(private val firebaseSignInManager: FirebaseSignInManager) {
    fun login(email: String, pass: String){
        firebaseSignInManager.login(email, pass)
    }

}