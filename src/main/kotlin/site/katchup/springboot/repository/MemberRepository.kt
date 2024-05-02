package site.katchup.springboot.repository

import org.springframework.data.jpa.repository.JpaRepository
import site.katchup.springboot.entity.Member
import site.katchup.springboot.exception.entity.EntityNotFoundException
import site.katchup.springboot.global.message.FailMessage

interface MemberRepository : JpaRepository<Member, Long> {
    fun findByIdOrThrow(id: Long): Member {
        return findById(id)
            .orElseThrow { throw EntityNotFoundException(FailMessage.MEMBER_NOT_FOUND) }
    }
}
