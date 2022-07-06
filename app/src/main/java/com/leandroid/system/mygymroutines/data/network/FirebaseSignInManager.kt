package com.leandroid.system.mygymroutines.data.network

import com.google.firebase.auth.FirebaseAuth

class FirebaseSignInManager(private val authListener: FirebaseSignInListener? = null){

    fun login(email: String, pass: String){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass)
            .addOnCompleteListener() {
             authListener?.loginResult(it.isSuccessful)
        }
    }
}