package com.davidmarian_buzatu.datafy.services

import com.davidmarian_buzatu.datafy.models.Blog
import javax.inject.Inject

class BlogService @Inject constructor(private val webService: WebService) {
    suspend fun getBlogs() = webService.getBlogs()

    suspend fun saveBlog(blog: Blog) = webService.saveBlog(blog)
}