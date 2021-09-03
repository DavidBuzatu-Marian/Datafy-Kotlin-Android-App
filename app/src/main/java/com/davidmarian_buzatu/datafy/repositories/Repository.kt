package com.davidmarian_buzatu.datafy.repositories

import com.davidmarian_buzatu.datafy.services.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class Repository {

    suspend fun <T> apiCallWithResponseWrapper(apiCall: suspend () -> T): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        Resource.Error(throwable.code(), throwable.response()?.errorBody())
                    }
                    else -> {
                        Resource.Error(null, null)
                    }
                }
            }
        }
    }
}