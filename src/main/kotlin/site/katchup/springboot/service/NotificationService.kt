package site.katchup.springboot.service

import org.springframework.stereotype.Service
import site.katchup.springboot.dto.notification.response.NotificationListResponse
import site.katchup.springboot.dto.notification.response.NotificationResponse

@Service
class NotificationService(
    private val notificationFinder: NotificationFinder,
) {

    fun getNotifications(memberId: Long): NotificationListResponse {
        return NotificationListResponse.of(
            notificationFinder.getAllByMemberId(memberId)
                .map {
                    NotificationResponse.of(it)
                },
        )
    }
}
