package com.davidmarian_buzatu.datafy.models

import java.io.Serializable

class Blog(private val title: String, private val content: String, private val url: String) : Serializable {
    fun getUrl() = url
    fun getContent() = content
    fun getTitle() = title

}