package com.davidmarian_buzatu.datafy.services

import com.davidmarian_buzatu.datafy.models.Blog
import retrofit2.http.GET

interface WebService {
    @GET("blog/")
    suspend fun getBlogs(): List<Blog>
}