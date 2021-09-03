package com.davidmarian_buzatu.datafy.repositories

import com.davidmarian_buzatu.datafy.models.Blog
import com.davidmarian_buzatu.datafy.services.WebService
import javax.inject.Inject

class BlogRepository @Inject constructor(private val webService: WebService) :Repository() {

    suspend fun saveBlog(blog: Blog) = apiCallWithResponseWrapper { webService.saveBlog(blog) }
}