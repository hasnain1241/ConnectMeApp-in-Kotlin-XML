package com.HasnainAkhtar.i221241

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.HasnainAkhtar.i221241.adapters.ProfileAdapter
import com.HasnainAkhtar.i221241.models.Profile

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val profileRecyclerView = findViewById<RecyclerView>(R.id.profileRecyclerView)
        val add=findViewById<ImageView>(R.id.add)
        val f1=findViewById<TextView>(R.id.followersCount)
        val f2=findViewById<TextView>(R.id.followingCount)

        add.setOnClickListener { startActivity(Intent(this, EditProfileActivity::class.java)) }
        f1.setOnClickListener { startActivity(Intent(this, FollowersFollowingActivity::class.java)) }
        f2.setOnClickListener { startActivity(Intent(this, FollowersFollowingActivity::class.java)) }

        // Sample posts (replace with actual data)
        val profileList = listOf(
            Profile(R.drawable.facebook),
            Profile(R.drawable.facebook),
            Profile(R.drawable.facebook)
        )

        // Setup RecyclerView (3 columns grid)
        profileRecyclerView.layoutManager = GridLayoutManager(this, 3)
        profileRecyclerView.adapter = ProfileAdapter(profileList)
    }
}
