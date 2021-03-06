package com.davidmarian_buzatu.datafy.services

import com.davidmarian_buzatu.datafy.models.Blog
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface WebService {
    @GET("blog/")
    suspend fun getBlogs(): List<Blog>

    @PUT("blog/save/")
    suspend fun saveBlog(@Body blog: Blog)
}