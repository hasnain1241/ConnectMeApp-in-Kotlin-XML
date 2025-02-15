package com.HasnainAkhtar.i221241

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.HasnainAkhtar.i221241.adapters.ContactAdapter
import com.HasnainAkhtar.i221241.models.Contact

class ContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        val contactRecyclerView = findViewById<RecyclerView>(R.id.contactRecyclerView)

        // Sample contact list
        val contactList = listOf(
            Contact(R.drawable.facebook, "Henry Benjamin", true),
            Contact(R.drawable.facebook, "Emily James", false),
            Contact(R.drawable.facebook, "Lily Thomas", false),
            Contact(R.drawable.facebook, "Christopher", false),
            Contact(R.drawable.google, "Amy Wesley", true),
            Contact(R.drawable.google, "Laura Ryan", false)
        )

        // Setup RecyclerView
        contactRecyclerView.layoutManager = LinearLayoutManager(this)
        contactRecyclerView.adapter = ContactAdapter(contactList) { contact ->
            val intent = Intent(this, ChatActivity::class.java)
            intent.putExtra("CONTACT_NAME", contact.name)
            intent.putExtra("CONTACT_IMAGE", contact.profileImageResId)
            startActivity(intent)
        }
    }
}
