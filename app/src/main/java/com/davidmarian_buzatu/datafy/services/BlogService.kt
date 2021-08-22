package com.davidmarian_buzatu.datafy.services

import javax.inject.Inject

class BlogService @Inject constructor(private val webService: WebService) {
    suspend fun getBlogs() = webService.getBlogs()
}