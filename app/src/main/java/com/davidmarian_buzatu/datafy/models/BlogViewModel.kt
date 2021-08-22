package com.davidmarian_buzatu.datafy.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidmarian_buzatu.datafy.repositories.BlogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlogViewModel @Inject constructor(blogRepository: BlogRepository) : ViewModel() {
    private val _blogs = MutableLiveData<List<Blog>>()
    val blogs: LiveData<List<Blog>> = _blogs

    init {
        viewModelScope.launch {
            _blogs.value = blogRepository.getBlogs()
        }
    }
}