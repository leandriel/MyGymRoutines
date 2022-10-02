package com.leandroid.system.mygymroutines.data.api.utils

import java.io.IOException

class NetworkException : IOException() {
    override val message: String?
        get() = NETWORK_ERROR

    companion object {
        const val NETWORK_ERROR = "Problemas con la conexión de Internet."
    }
}