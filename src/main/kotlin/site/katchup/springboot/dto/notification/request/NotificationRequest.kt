package site.katchup.springboot.dto.notification.request

data class NotificationRequest(
    val title: String,
    val content: String,
    val isPush: Boolean,
)
