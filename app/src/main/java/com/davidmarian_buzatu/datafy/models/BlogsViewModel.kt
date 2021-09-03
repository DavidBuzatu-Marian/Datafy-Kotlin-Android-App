package com.davidmarian_buzatu.datafy.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidmarian_buzatu.datafy.repositories.BlogsRepository
import com.davidmarian_buzatu.datafy.services.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.nio.charset.StandardCharsets
import java.util.*
import javax.inject.Inject

@HiltViewModel
class BlogsViewModel @Inject constructor(blogsRepository: BlogsRepository) : ViewModel() {
    private val _blogs = MutableLiveData<Resource<List<Blog>>>()
    val blogs: LiveData<Resource<List<Blog>>> = _blogs

    init {
        viewModelScope.launch {
            _blogs.value = blogsRepository.getBlogs()
        }
    }
}