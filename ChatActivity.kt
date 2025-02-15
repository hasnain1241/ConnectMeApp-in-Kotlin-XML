package com.HasnainAkhtar.i221241

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.HasnainAkhtar.i221241.adapters.MessageAdapter
import com.HasnainAkhtar.i221241.models.Message

class ChatActivity : AppCompatActivity() {

    private lateinit var tvContactName: TextView
    private lateinit var ivContactProfile: ImageView
    private lateinit var rvMessages: RecyclerView
    private lateinit var etMessage: EditText
    private lateinit var btnSend: ImageView
    private lateinit var btnBack: ImageView
    private lateinit var btnCall: ImageView
    private lateinit var btnVideoCall: ImageView
    private lateinit var messageAdapter: MessageAdapter
    private val messageList = mutableListOf<Message>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        tvContactName = findViewById(R.id.tvContactName)
        ivContactProfile = findViewById(R.id.ivContactProfile)
        rvMessages = findViewById(R.id.rvMessages)
        etMessage = findViewById(R.id.etMessage)
        btnSend = findViewById(R.id.btnSend)
        btnBack = findViewById(R.id.btnBack)
        btnCall = findViewById(R.id.btnCall)
        btnVideoCall = findViewById(R.id.btnVideoCall)

        val contactName = intent.getStringExtra("CONTACT_NAME") ?: "Unknown"
        val contactImage = intent.getIntExtra("CONTACT_IMAGE", R.drawable.facebook)

        tvContactName.text = contactName
        ivContactProfile.setImageResource(contactImage)

        setupRecyclerView()

        btnSend.setOnClickListener { sendMessage() }

        // Navigate back to Contact Page
        btnBack.setOnClickListener { finish() }

        // Navigate to Call Activity
        btnCall.setOnClickListener {
            val intent = Intent(this, CallActivity::class.java)
            intent.putExtra("CONTACT_NAME", contactName)
            intent.putExtra("CONTACT_IMAGE", contactImage)
            intent.putExtra("CALL_TYPE", "audio")
            startActivity(intent)
        }

        // Navigate to Video Call Activity
        btnVideoCall.setOnClickListener {
            val intent = Intent(this, CallActivity::class.java)
            intent.putExtra("CONTACT_NAME", contactName)
            intent.putExtra("CONTACT_IMAGE", contactImage)
            intent.putExtra("CALL_TYPE", "video")
            startActivity(intent)
        }
    }

    private fun setupRecyclerView() {
        rvMessages.layoutManager = LinearLayoutManager(this)
        messageAdapter = MessageAdapter(messageList)
        rvMessages.adapter = messageAdapter

        // Load Dummy Messages
        messageList.addAll(
            listOf(
                Message("Hello, How are you?", true, "10:30"),
                Message("Hi, I am great, Wbu?", false, "10:32"),
                Message("I am doing well", true, "01:30"),
                Message("Good to know", false, "01:30")
            )
        )
        messageAdapter.notifyDataSetChanged()
    }

    private fun sendMessage() {
        val text = etMessage.text.toString().trim()
        if (text.isNotEmpty()) {
            messageList.add(Message(text, true, "Now"))
            messageAdapter.notifyItemInserted(messageList.size - 1)
            rvMessages.scrollToPosition(messageList.size - 1)
            etMessage.text.clear()
        }
    }
}
