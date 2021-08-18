package com.davidmarian_buzatu.datafy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.davidmarian_buzatu.datafy.blog.BLOG
import com.davidmarian_buzatu.datafy.models.Blog

class BlogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog)

        val blog: Blog = intent.getSerializableExtra(BLOG) as Blog
        val textViewBlogTitle: TextView = findViewById(R.id.activity_blog_tv_title)
        val textViewBlogContent: TextView = findViewById(R.id.activity_blog_tv_content)

        textViewBlogTitle.text = blog.getTitle()
        textViewBlogContent.text = blog.getContent()
    }
}