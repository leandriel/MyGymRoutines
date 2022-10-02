package com.leandroid.system.mygymroutines.data.api.utils

import java.io.IOException

class TokenException: IOException(){
    override val message: String?
        get() = TOKEN_ERROR

    companion object {
        const val TOKEN_ERROR = "Sesión expirada."
    }
}