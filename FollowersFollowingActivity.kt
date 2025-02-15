package com.HasnainAkhtar.i221241

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.HasnainAkhtar.i221241.databinding.ActivityFollowersFollowingBinding

class FollowersFollowingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFollowersFollowingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFollowersFollowingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load FollowersFragment by default
        loadFragment(FollowersFragment())

        binding.tvFollowers.setOnClickListener {
            loadFragment(FollowersFragment())
        }

        binding.tvFollowing.setOnClickListener {
            loadFragment(FollowingFragment())
        }

        binding.btnBack.setOnClickListener {
            finish() // Closes the activity
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
