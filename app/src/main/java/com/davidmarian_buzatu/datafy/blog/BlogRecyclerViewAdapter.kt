package com.davidmarian_buzatu.datafy.blog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.davidmarian_buzatu.datafy.R

class BlogRecyclerViewAdapter(private val blogs: List<String>): RecyclerView.Adapter<BlogRecyclerViewAdapter.ViewHolder>
    () {
        class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
            val textView: TextView

            init {
                textView = view.findViewById(R.id.blog_recycler_view_card_tv_title)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.blog_recycler_view_card, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = blogs[position]
    }

    override fun getItemCount() = blogs.size

}