package com.HasnainAkhtar.i221241

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val profileImage = findViewById<ImageView>(R.id.profileImage)
        val nameEditText = findViewById<EditText>(R.id.etName)
        val usernameEditText = findViewById<EditText>(R.id.etUsername)
        val contactEditText = findViewById<EditText>(R.id.etContact)
        val bioEditText = findViewById<EditText>(R.id.etBio)
        val doneButton = findViewById<TextView>(R.id.tvDone)
        val b2=findViewById<ImageView>(R.id.btnBack)

        // Load existing user data (Mock example)
        nameEditText.setText("Olivia Daniel")
        usernameEditText.setText("OliviaD")
        contactEditText.setText("+42 7412 5443058")
        bioEditText.setText("Just an average 14-year-old")

        doneButton.setOnClickListener {
            // Save the updated information (Implement saving logic if needed)
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
        b2.setOnClickListener {

            val intent= Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()

        }

    }
}
