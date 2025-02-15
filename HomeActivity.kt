package com.HasnainAkhtar.i221241

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.HasnainAkhtar.i221241.adapters.StoryAdapter
import com.HasnainAkhtar.i221241.adapters.PostAdapter
import com.HasnainAkhtar.i221241.models.Story
import com.HasnainAkhtar.i221241.models.Post

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val storyRecyclerView = findViewById<RecyclerView>(R.id.storyRecyclerView)
        val postRecyclerView = findViewById<RecyclerView>(R.id.postRecyclerView)

        val tvMyContacts = findViewById<TextView>(R.id.tvMyContacts)

        tvMyContacts.setOnClickListener {
            startActivity(Intent(this, PeopleActivity::class.java))
        }

        // Sample data for Stories
        val storyList = listOf(
            Story(R.drawable.facebook),
            Story(R.drawable.google),
            Story(R.drawable.apple)
        )

        // Sample data for Posts
        val postList = listOf(
            Post(R.drawable.facebook, "User1", R.drawable.facebook, "This is a sample post."),
            Post(R.drawable.phone, "User2", R.drawable.phone, "Another amazing post!")
        )

        // Setup Story RecyclerView
        storyRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        storyRecyclerView.adapter = StoryAdapter(storyList)

        // Setup Post RecyclerView
        postRecyclerView.layoutManager = LinearLayoutManager(this)
        postRecyclerView.adapter = PostAdapter(postList)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_search -> {
                    startActivity(Intent(this, SearchActivity::class.java))
                    true
                }
                R.id.nav_add -> {
                    startActivity(Intent(this, AddNewPostActivity::class.java))
                    true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }
                R.id.nav_contacts -> {

                    startActivity(Intent(this, ContactActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}
