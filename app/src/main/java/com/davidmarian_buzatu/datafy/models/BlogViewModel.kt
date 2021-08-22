package com.davidmarian_buzatu.datafy.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class BlogViewModel : ViewModel() {
    val blogs: LiveData<List<Blog>> = TODO()
}