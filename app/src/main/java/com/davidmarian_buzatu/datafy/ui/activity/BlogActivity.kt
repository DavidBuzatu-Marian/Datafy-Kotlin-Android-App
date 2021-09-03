package com.davidmarian_buzatu.datafy.ui.activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import com.davidmarian_buzatu.datafy.R
import com.davidmarian_buzatu.datafy.models.Blog
import com.davidmarian_buzatu.datafy.repositories.BlogRepository
import com.davidmarian_buzatu.datafy.services.Resource
import com.davidmarian_buzatu.datafy.ui.adapter.BLOG
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import io.noties.markwon.Markwon
import io.noties.markwon.html.HtmlPlugin
import io.noties.markwon.image.ImagesPlugin
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class BlogActivity : AppCompatActivity() {
    private lateinit var activityBlog: Blog
    private lateinit var currentContent: String

    @Inject
    lateinit var blogRepository: BlogRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog)

        setActivityBlog(intent)
        setCurrentContent()
        setNonEditableInitialText()
        setEditableInitialText()
        setEditableListeners()
        setMarkwon()
        setSaveButton()
    }

    private fun setSaveButton() {
        val saveButton: FloatingActionButton = findViewById(R.id.activity_blog_fab_save)
        saveButton.setOnClickListener {
            lifecycleScope.launch {
                activityBlog.let { blog ->
                    val it = blogRepository.saveBlog(blog)
                    when (it) {
                        is Resource.Success -> {
                            Toast.makeText(this@BlogActivity, "Saved Blog!", Toast.LENGTH_SHORT).show()
                        }
                        is Resource.Error -> {
                            Toast.makeText(this@BlogActivity, "Error saving blog! Error: ${it.errorMessage}. ErrorCode: ${it.errorCode}", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
    }

    private fun setCurrentContent() {
        currentContent = decodeBase64ToString(activityBlog.getContent())
    }

    private fun setMarkwon() {
        val textViewBlogContent: TextView = findViewById(R.id.activity_blog_tv_content)
        val markwon: Markwon = Markwon.builder(this)
            .usePlugin(HtmlPlugin.create())
            .usePlugin(ImagesPlugin.create())
            .build()
        markwon.setMarkdown(textViewBlogContent, currentContent)
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
        activityBlog.setTitle(text.toString())
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

        editTextBlogTitle.setText(activityBlog.getTitle())
        editTextBlogContent.setText(decodeBase64ToString((activityBlog.getContent())))
    }

    private fun setNonEditableInitialText() {
        val textViewBlogTitle: TextView = findViewById(R.id.activity_blog_tv_title)
        val textViewBlogContent: TextView = findViewById(R.id.activity_blog_tv_content)

        textViewBlogTitle.text = activityBlog.getTitle()
        textViewBlogContent.text = decodeBase64ToString(activityBlog.getContent())
    }

    private fun setActivityBlog(intent: Intent) {
        activityBlog = intent.getSerializableExtra(BLOG) as Blog
    }

    private fun decodeBase64ToString(base64String: String): String {
        val base64Content = Base64.getMimeDecoder().decode(base64String)
        return String(base64Content)
    }

    private fun encodeStringToBase64(text: String): String {
        return Base64.getEncoder().encodeToString(text.encodeToByteArray())
    }
}