package site.katchup.springboot.dto.notification.response

import com.fasterxml.jackson.annotation.JsonFormat
import site.katchup.springboot.entity.Notification
import java.time.LocalDateTime

class NotificationResponse(
    val id: Long,
    val title: String,
    val content: String,
    val isRead: Boolean,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    val createdAt: LocalDateTime,
) {
    companion object {
        fun of(
            notification: Notification,
        ) = NotificationResponse(
            id = notification.id!!,
            title = notification.title,
            content = notification.content,
            isRead = notification.isRead,
            createdAt = notification.createdAt,
        )
    }
}
