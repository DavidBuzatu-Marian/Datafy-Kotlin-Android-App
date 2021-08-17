package com.davidmarian_buzatu.datafy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.davidmarian_buzatu.datafy.blog.BlogRecyclerViewAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        val blogsRecyclerView: RecyclerView = findViewById(R.id.activity_main_rv_blogs)
        blogsRecyclerView.adapter = BlogRecyclerViewAdapter(listOf<String>("test", "test2"))
        blogsRecyclerView.layoutManager = linearLayoutManager
    }
}