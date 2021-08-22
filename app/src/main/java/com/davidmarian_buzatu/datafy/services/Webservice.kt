package com.davidmarian_buzatu.datafy.services

import com.davidmarian_buzatu.datafy.models.Blog
import retrofit2.http.GET

interface Webservice {
    @GET("/api/blog")
    suspend fun getBlogs(): List<Blog>
}