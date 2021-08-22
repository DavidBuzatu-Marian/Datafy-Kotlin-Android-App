package com.davidmarian_buzatu.datafy.repositories

import com.davidmarian_buzatu.datafy.services.Webservice

class BlogRepository {

    private val webservice: Webservice = TODO()

    suspend fun getBlogs() = webservice.getBlogs()
}