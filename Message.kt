package com.HasnainAkhtar.i221241.models

data class Message(
    val text: String,
    val isSent: Boolean,  // true = Sent message (right), false = Received message (left)
    val timestamp: String
)
