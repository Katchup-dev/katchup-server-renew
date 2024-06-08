package site.katchup.springboot.repository

import org.springframework.data.jpa.repository.JpaRepository
import site.katchup.springboot.entity.FcmToken

interface FcmTokenRepository : JpaRepository<FcmToken, Long> {
    fun findAllByMemberId(memberId: Long): List<FcmToken>
}
