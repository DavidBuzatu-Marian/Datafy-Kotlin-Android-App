package com.davidmarian_buzatu.datafy.ui.activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.davidmarian_buzatu.datafy.R
import com.davidmarian_buzatu.datafy.models.Blog
import com.davidmarian_buzatu.datafy.ui.adapter.BLOG
import java.nio.charset.StandardCharsets
import java.util.*

class BlogActivity : AppCompatActivity() {
    private var activityBlog: Blog? = null
    private lateinit var currentContent: String

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
        currentContent = text.toString()
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
        editTextBlogContent.setText(decodeBase64ToString((activityBlog!!.getContent())))
    }

    private fun setNonEditableInitialText() {
        val textViewBlogTitle: TextView = findViewById(R.id.activity_blog_tv_title)
        val textViewBlogContent: TextView = findViewById(R.id.activity_blog_tv_content)

        textViewBlogTitle.text = activityBlog!!.getTitle()
        textViewBlogContent.text = decodeBase64ToString(activityBlog!!.getContent())
    }

    private fun setActivityBlog(intent: Intent) {
        activityBlog = intent.getSerializableExtra(BLOG) as Blog
    }

    private fun decodeBase64ToString(base64String: String): String {
        println(base64String)
        val base64Content = Base64.getMimeDecoder().decode(base64String)
        return String(base64Content)
    }

    private fun encodeStringToBase64(text: String): String {
        return Base64.getEncoder().encodeToString(text.encodeToByteArray())
    }
}