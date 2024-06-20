package site.katchup.springboot.service.notification

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import site.katchup.springboot.dto.notification.request.NotificationRequest
import site.katchup.springboot.dto.notification.response.NotificationListResponse
import site.katchup.springboot.dto.notification.response.NotificationResponse
import site.katchup.springboot.entity.Notification
import site.katchup.springboot.external.fcm.FcmRequest
import site.katchup.springboot.external.fcm.FcmSender
import site.katchup.springboot.repository.FcmTokenRepository
import site.katchup.springboot.repository.NotificationRepository

@Service
@Transactional(readOnly = true)
class NotificationService(
    private val notificationFinder: NotificationFinder,
    private val notificationRepository: NotificationRepository,
    private val fcmTokenRepository: FcmTokenRepository,
    private val fcmSender: FcmSender,
) {

    fun getNotifications(memberId: Long): NotificationListResponse {
        return NotificationListResponse.of(
            notificationFinder.getAllByMemberId(memberId)
                .map {
                    NotificationResponse.of(it)
                },
        )
    }

    @Transactional
    fun addNotification(memberId: Long, request: NotificationRequest) {
        if (request.isPush) {
            fcmTokenRepository.findAllByMemberId(memberId)
                .map {
                    fcmSender.sendMessage(
                        FcmRequest(
                            targetToken = it.token,
                            title = request.title,
                            content = request.content,
                        ),
                    )
                }
        }
        notificationRepository.save(
            Notification(
                memberId = memberId,
                title = request.title,
                content = request.content,
                isRead = false,
            ),
        )
    }
}
