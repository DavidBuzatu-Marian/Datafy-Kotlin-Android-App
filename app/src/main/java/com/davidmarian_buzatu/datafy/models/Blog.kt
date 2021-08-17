package com.davidmarian_buzatu.datafy.models

class Blog(private val title: String, private val content: String, private val url: String) {
    fun getUrl() = url
    fun getTitle() = title

}