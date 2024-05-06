package site.katchup.springboot.repository

import org.springframework.data.jpa.repository.JpaRepository
import site.katchup.springboot.entity.Notification

interface NotificationRepository : JpaRepository<Notification, Long> {
    fun findAllByMemberIdOrderByCreatedAtDesc(memberId: Long): List<Notification>
}
