package com.HasnainAkhtar.i221241

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PostDetailsActivity : AppCompatActivity() {

    private lateinit var ivBack: ImageView
    private lateinit var ivSelectedImage: ImageView
    private lateinit var etCaption: EditText
    private lateinit var btnShare: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_details)

        ivBack = findViewById(R.id.ivBack)
        ivSelectedImage = findViewById(R.id.ivSelectedImage)
        etCaption = findViewById(R.id.etCaption)
        btnShare = findViewById(R.id.btnShare)

        // Handle back button click
        ivBack.setOnClickListener {
            finish()  // Go back to previous screen
        }

        // Handle share button click
        btnShare.setOnClickListener {
            val caption = etCaption.text.toString().trim()
            if (caption.isEmpty()) {
                Toast.makeText(this, "Please enter a caption", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "POSTED!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
