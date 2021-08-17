package com.davidmarian_buzatu.datafy.models

import java.lang.Integer.min

const val DESCRIPTION_SIZE = 1000

class Blog(private val title: String, private val content: String, private val url: String) {
    fun getContentDescription() = content.substring(0, min(content.length, DESCRIPTION_SIZE))
    fun getTitle() = title

}