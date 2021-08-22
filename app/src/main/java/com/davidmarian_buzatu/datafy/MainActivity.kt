package com.davidmarian_buzatu.datafy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.davidmarian_buzatu.datafy.blog.BlogRecyclerViewAdapter
import com.davidmarian_buzatu.datafy.models.BlogViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private val blogViewModel: BlogViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        val blogsRecyclerView: RecyclerView =
            findViewById(R.id.activity_main_rv_blogs)
        blogsRecyclerView.layoutManager = linearLayoutManager
        blogViewModel.blogs.observe(this, {
            blogsRecyclerView.adapter = BlogRecyclerViewAdapter(it)
        })
    }
}