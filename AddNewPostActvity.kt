package com.HasnainAkhtar.i221241

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AddNewPostActivity : AppCompatActivity() {

    private lateinit var ivSelectedImage: ImageView
    private lateinit var rvGallery: RecyclerView
    private lateinit var tvNext: TextView
    private lateinit var galleryAdapter: GalleryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_post)

        ivSelectedImage = findViewById(R.id.ivSelectedImage)
        rvGallery = findViewById(R.id.rvGallery)
        tvNext = findViewById(R.id.tvNext)

        setupGalleryRecyclerView()
        tvNext.setOnClickListener {
            val intent = Intent(this, PostDetailsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupGalleryRecyclerView() {
        rvGallery.layoutManager = GridLayoutManager(this, 3)
        galleryAdapter = GalleryAdapter(getGalleryImages()) { selectedImage ->
            ivSelectedImage.setImageResource(selectedImage)
        }
        rvGallery.adapter = galleryAdapter
    }

    private fun getGalleryImages(): List<Int> {
        return listOf(
            R.drawable.facebook, R.drawable.apple, R.drawable.facebook,
            R.drawable.google, R.drawable.facebook, R.drawable.facebook
        )
    }




}
