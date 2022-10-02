package com.leandroid.system.mygymroutines.data.api.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponseError (
    val error: String,
    val message: String){
    constructor(): this("status", "error")
}