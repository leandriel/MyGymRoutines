package com.leandroid.system.mygymroutines.data.api.utils

import java.io.IOException

class UnknownException: IOException(){
    override val message: String?
        get() = UNKNOWN_ERROR

    companion object {
        const val UNKNOWN_ERROR = "Problema desconocido."
    }
}