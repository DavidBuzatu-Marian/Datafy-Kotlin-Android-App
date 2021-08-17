package com.davidmarian_buzatu.datafy.blog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.davidmarian_buzatu.datafy.R
import com.davidmarian_buzatu.datafy.models.Blog
import io.noties.markwon.Markwon
import io.noties.markwon.html.HtmlPlugin

class BlogRecyclerViewAdapter(private val blogs: List<Blog>): RecyclerView.Adapter<BlogRecyclerViewAdapter.ViewHolder>
    () {
        class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
            val textViewBlogTitle: TextView = view.findViewById(R.id.blog_recycler_view_card_tv_title)
            val textViewBlogContent: TextView = view.findViewById(R.id.blog_recycler_view_card_tv_content)
            val markwon: Markwon = Markwon.builder(view.context).usePlugin(
                HtmlPlugin.create())
                .build();
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.blog_recycler_view_card, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewBlogTitle.text = blogs[position].getTitle()
        holder.markwon.setMarkdown(holder.textViewBlogContent, blogs[position].getContentDescription())
    }

    override fun getItemCount() = blogs.size

}