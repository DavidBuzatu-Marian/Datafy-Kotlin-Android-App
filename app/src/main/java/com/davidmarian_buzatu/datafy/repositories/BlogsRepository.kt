package com.davidmarian_buzatu.datafy.repositories

import com.davidmarian_buzatu.datafy.models.Blog
import com.davidmarian_buzatu.datafy.services.WebService
import javax.inject.Inject

class BlogsRepository @Inject constructor(
    private val webService: WebService
) {

    suspend fun getBlogs() =  webService.getBlogs()
    suspend fun saveBlog(blog: Blog) = webService.saveBlog(blog)
}