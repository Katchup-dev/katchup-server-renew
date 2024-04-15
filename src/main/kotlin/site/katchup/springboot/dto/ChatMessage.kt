package site.katchup.springboot.dto

class ChatMessage(
    val type: String,
    val sender: String,
    val channelId: String,
    val data: Any,
)
