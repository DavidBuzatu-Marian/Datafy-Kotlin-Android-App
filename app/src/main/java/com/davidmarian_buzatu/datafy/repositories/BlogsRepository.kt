package com.davidmarian_buzatu.datafy.repositories

import com.davidmarian_buzatu.datafy.models.Blog
import com.davidmarian_buzatu.datafy.services.Resource
import com.davidmarian_buzatu.datafy.services.WebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

class BlogsRepository @Inject constructor(
    private val webService: WebService
) : Repository() {

    suspend fun getBlogs() = apiCallWithResponseWrapper { webService.getBlogs() }
}