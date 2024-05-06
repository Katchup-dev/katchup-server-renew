package site.katchup.springboot.dto.notification.response

class NotificationListResponse(
    val notifications: List<NotificationResponse>,
) {

    companion object {
        @JvmStatic
        fun of(
            notifications: List<NotificationResponse>,
        ) = NotificationListResponse(
            notifications = notifications,
        )
    }
}
