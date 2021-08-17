package com.davidmarian_buzatu.datafy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.davidmarian_buzatu.datafy.blog.BlogRecyclerViewAdapter
import com.davidmarian_buzatu.datafy.models.Blog

class MainActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        val blogsRecyclerView: RecyclerView =
            findViewById(R.id.activity_main_rv_blogs)
        blogsRecyclerView.adapter = BlogRecyclerViewAdapter(
            listOf(
                Blog(
                    "This is some title",
                    "test2test2test2test2test2test2test2test2test2",
                    "url"
                ),
                Blog(
                    "Docker.Kubernetes and what not?",
                    "<p>Posted on 10.10.2021</p>\n" +
                            "\n" +
                            "<img src=\"https://i.ibb.co/C2K1gSk/pexels-lee-campbell-115655.jpg\" alt=\"pexels-lee-campbell-115655\"/>\n" +
                            "\n" +
                            "# This is a test blog\n" +
                            "\n" +
                            "'[\"Database\", \"AWS\"]'\n" +
                            "\n" +
                            "## This should be recognized as a sub-title\n" +
                            "\n" +
                            "<div id=\"this should be recognized as a sub-title\"><p>Mauris maximus nec ligula sed ullamcorper. Quisque semper eget felis ut semper. Sed sem leo, malesuada sit amet imperdiet eu, iaculis a nisi. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aliquam erat volutpat. Mauris placerat eros id ligula posuere, at tincidunt orci pellentesque. Mauris lobortis tempus nisl, sit amet mollis nisl facilisis eu. Etiam congue libero ac est convallis, ac sollicitudin mi vulputate. Nunc sagittis mi malesuada augue bibendum pulvinar. Cras molestie ut leo eget vestibulum. In molestie sollicitudin metus eget facilisis. Cras sit amet cursus lorem.</p></div>\n" +
                            "\n" +
                            "## This should be recognized as a sub-title as well\n" +
                            "\n" +
                            "<div id=\"this should be recognized as a sub-title as well\"><p>Phasellus eu dui ac urna maximus rutrum. Nullam sodales velit id nisl sagittis finibus. Donec porttitor pulvinar porttitor. Duis eget odio sed augue porta interdum placerat et mauris. Duis auctor purus dapibus, ultricies eros sed, pretium eros. Nunc a mi in odio sagittis luctus. Suspendisse nec dignissim libero. Sed tincidunt molestie blandit. Vestibulum accumsan lobortis elit, id rutrum risus rutrum a. Nunc elementum, nunc a suscipit ultrices, neque tortor euismod felis, ac ultricies diam augue ut odio. Integer eget varius elit. Etiam aliquam vehicula facilisis. Nulla eget sollicitudin tellus, et porta mi.\n" +
                            "\n" +
                            "<p id=\"this should be recognized as a sub-title as well\">Phasellus eu dui ac urna maximus rutrum. Nullam sodales velit id nisl sagittis finibus. Donec porttitor pulvinar porttitor. Duis eget odio sed augue porta interdum placerat et mauris. Duis auctor purus dapibus, ultricies eros sed, pretium eros. Nunc a mi in odio sagittis luctus. Suspendisse nec dignissim libero. Sed tincidunt molestie blandit. Vestibulum accumsan lobortis elit, id rutrum risus rutrum a. Nunc elementum, nunc a suscipit ultrices, neque tortor euismod felis, ac ultricies diam augue ut odio. Integer eget varius elit. Etiam aliquam vehicula facilisis. Nulla eget sollicitudin tellus, et porta mi.</p>\n" +
                            "\n" +
                            "<p id=\"this should be recognized as a sub-title as well\">Phasellus eu dui ac urna maximus rutrum. Nullam sodales velit id nisl sagittis finibus. Donec porttitor pulvinar porttitor. Duis eget odio sed augue porta interdum placerat et mauris. Duis auctor purus dapibus, ultricies eros sed, pretium eros. Nunc a mi in odio sagittis luctus. Suspendisse nec dignissim libero. Sed tincidunt molestie blandit. Vestibulum accumsan lobortis elit, id rutrum risus rutrum a. Nunc elementum, nunc a suscipit ultrices, neque tortor euismod felis, ac ultricies diam augue ut odio. Integer eget varius elit. Etiam aliquam vehicula facilisis. Nulla eget sollicitudin tellus, et porta sfsmi.1ed67d2a81b7f089ad449f6d9550dcc7e7509856</div>",
                    "url"
                ),
                Blog(
                    "test",
                    "testtest2test2test2test2test2test2test2test2test22",
                    "url"
                )
            )
        )
        blogsRecyclerView.layoutManager = linearLayoutManager
    }
}