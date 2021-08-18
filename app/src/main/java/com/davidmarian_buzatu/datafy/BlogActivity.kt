package com.davidmarian_buzatu.datafy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.davidmarian_buzatu.datafy.blog.BLOG
import com.davidmarian_buzatu.datafy.models.Blog

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
        val editTextBlogTitle: EditText = findViewById(R.id.activity_blog_et_title)
        val editTextBlogContent: EditText = findViewById(R.id.activity_blog_et_content)

        editTextBlogTitle.addTextChangedListener { text ->
            changeBlogTitle(text)
            changeBlogTitleTextView(text)
        }

        editTextBlogContent.addTextChangedListener { text ->
            changeBlogContent(text)
            changeBlogContentTextView(text)
        }
    }

    private fun changeBlogContent(text: Editable?) {
        activityBlog!!.setContent(text.toString())
    }

    private fun changeBlogTitle(text: Editable?) {
        activityBlog!!.setTitle(text.toString())
    }

    private fun changeBlogContentTextView(text: Editable?) {
        val textViewBlogContent: TextView = findViewById(R.id.activity_blog_tv_content)
        textViewBlogContent.text = text
    }

    private fun changeBlogTitleTextView(text: Editable?) {
        val textViewBlogTitle: TextView = findViewById(R.id.activity_blog_tv_title)
        textViewBlogTitle.text = text
    }

    private fun setEditableInitialText() {
        val editTextBlogTitle: EditText = findViewById(R.id.activity_blog_et_title)
        val editTextBlogContent: EditText = findViewById(R.id.activity_blog_et_content)

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