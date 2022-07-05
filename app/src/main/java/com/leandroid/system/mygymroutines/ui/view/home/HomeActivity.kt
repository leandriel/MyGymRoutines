package com.leandroid.system.mygymroutines.ui.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.leandroid.system.mygymroutines.R

enum class ProviderType{
    BASIC
}

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}