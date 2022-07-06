package com.leandroid.system.mygymroutines.ui.view.signin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.leandroid.system.mygymroutines.databinding.ActivitySignInBinding


class SignInActivity : AppCompatActivity(){
    private lateinit var binding: ActivitySignInBinding

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivitySignInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

}