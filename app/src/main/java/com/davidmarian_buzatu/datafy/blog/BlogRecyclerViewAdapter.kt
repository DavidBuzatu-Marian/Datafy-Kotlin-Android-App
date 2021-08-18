package com.davidmarian_buzatu.datafy.blog

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.davidmarian_buzatu.datafy.BlogActivity
import com.davidmarian_buzatu.datafy.R
import com.davidmarian_buzatu.datafy.models.Blog

const val BLOG = "BLOG"

class BlogRecyclerViewAdapter(private val blogs: List<Blog>) :
    RecyclerView.Adapter<BlogRecyclerViewAdapter.ViewHolder>
        () {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val context = view.context
        val textViewBlogTitle: TextView =
            view.findViewById(R.id.blog_recycler_view_card_tv_title)
        val buttonEditBlog: Button = view.findViewById(R.id.blog_recycler_view_card_btn_edit);
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.blog_recycler_view_card, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewBlogTitle.text = blogs[position].getTitle()
        holder.buttonEditBlog.setOnClickListener {
            val blogIntent = Intent(holder.context, BlogActivity::class.java).apply {
                putExtra(BLOG, blogs[position])
            }
            holder.context.startActivity(blogIntent)
        }

    }

    override fun getItemCount() = blogs.size

}