package site.katchup.springboot.service

import org.springframework.stereotype.Component
import site.katchup.springboot.entity.Notification
import site.katchup.springboot.repository.NotificationRepository

@Component
class NotificationFinder(
    private val notificationRepository: NotificationRepository,
) {

    fun getAllByMemberId(memberId: Long): List<Notification> {
        return notificationRepository.findAllByMemberIdOrderByCreatedAtDesc(memberId)
    }
}
