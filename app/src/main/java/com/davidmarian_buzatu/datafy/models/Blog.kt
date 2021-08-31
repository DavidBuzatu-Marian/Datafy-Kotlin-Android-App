package com.davidmarian_buzatu.datafy.models

import java.io.Serializable
import java.nio.charset.StandardCharsets
import java.util.*

class Blog(private var title: String, private var content: String, private var url: String) : Serializable {

    fun getUrl() = url
    fun getContent() = content
    fun getTitle() = title
    fun setTitle(title: String) {
        this.title = title
    }

    fun setContent(content: String) {
        this.content = content
    }

}