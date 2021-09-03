package com.davidmarian_buzatu.datafy.services

import okhttp3.ResponseBody

sealed class Resource<out T> {
    data class Success<out T>(val data: T): Resource<T>()
    data class Error(val errorCode: Int?, val errorMessage: ResponseBody?): Resource<Nothing>()
}
