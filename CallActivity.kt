package com.HasnainAkhtar.i221241

import android.hardware.biometrics.PromptContentViewWithMoreOptionsButton
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CallActivity : AppCompatActivity() {

    private lateinit var tvContactName: TextView
    private lateinit var ivContactProfile: ImageView
    private lateinit var btnEndCall: ImageView
    private lateinit var btnMoreOptions: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actvity_call)

        tvContactName = findViewById(R.id.tvContactName)
        ivContactProfile = findViewById(R.id.ivProfile)
        btnEndCall = findViewById(R.id.btnEndCall)
        btnMoreOptions= findViewById(R.id.btnMoreOptions)

        val contactName = intent.getStringExtra("CONTACT_NAME") ?: "Unknown"
        val contactImage = intent.getIntExtra("CONTACT_IMAGE", R.drawable.facebook)
        val callType = intent.getStringExtra("CALL_TYPE")

        tvContactName.text = contactName
        ivContactProfile.setImageResource(contactImage)

        // Handle End Call
        btnEndCall.setOnClickListener { finish() }
        btnMoreOptions.setOnClickListener { finish() }
    }
}
