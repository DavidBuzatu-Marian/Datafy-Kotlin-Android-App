package com.davidmarian_buzatu.datafy.repositories

import com.davidmarian_buzatu.datafy.services.WebService
import javax.inject.Inject

class BlogRepository @Inject constructor(
    private val webService: WebService
) {

    suspend fun getBlogs() = webService.getBlogs()
}