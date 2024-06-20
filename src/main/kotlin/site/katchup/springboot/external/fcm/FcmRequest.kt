package site.katchup.springboot.external.fcm

data class FcmRequest(
    val targetToken: String,
    val title: String,
    val content: String,
)
