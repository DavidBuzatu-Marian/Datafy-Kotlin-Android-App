package com.davidmarian_buzatu.datafy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.davidmarian_buzatu.datafy.blog.BLOG
import com.davidmarian_buzatu.datafy.models.Blog
import com.google.android.material.textfield.TextInputEditText

class BlogActivity : AppCompatActivity() {
    private var activityBlog: Blog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog)

        setActivityBlog(intent)
        setNonEditableInitialText()
        setEditableInitialText()
        setEditableListeners()
    }

    private fun setEditableListeners() {
        val editTextBlogTitle: TextInputEditText = findViewById(R.id.activity_blog_tiet_title)
        val editTextBlogContent: TextInputEditText = findViewById(R.id.activity_blog_tiet_content)

        editTextBlogTitle.addTextChangedListener {
            text -> activityBlog!!.setTitle(text.toString())
            val textViewBlogTitle: TextView = findViewById(R.id.activity_blog_tv_title)
            textViewBlogTitle.text = text
         }

        editTextBlogContent.addTextChangedListener {
                text -> activityBlog!!.setContent(text.toString())
            val textViewBlogContent: TextView = findViewById(R.id.activity_blog_tv_content)
            textViewBlogContent.text = text
        }
    }

    private fun setEditableInitialText() {
        val editTextBlogTitle: TextInputEditText = findViewById(R.id.activity_blog_tiet_title)
        val editTextBlogContent: TextInputEditText = findViewById(R.id.activity_blog_tiet_content)

        editTextBlogTitle.setText(activityBlog!!.getTitle())
        editTextBlogContent.setText(activityBlog!!.getContent())
    }

    private fun setNonEditableInitialText() {
        val textViewBlogTitle: TextView = findViewById(R.id.activity_blog_tv_title)
        val textViewBlogContent: TextView = findViewById(R.id.activity_blog_tv_content)

        textViewBlogTitle.text = activityBlog!!.getTitle()
        textViewBlogContent.text = activityBlog!!.getContent()
    }

    private fun setActivityBlog(intent: Intent) {
        activityBlog = intent.getSerializableExtra(BLOG) as Blog
    }
}