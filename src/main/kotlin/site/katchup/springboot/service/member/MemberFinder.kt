package site.katchup.springboot.service.member

import org.springframework.stereotype.Component
import site.katchup.springboot.entity.Member
import site.katchup.springboot.exception.entity.EntityNotFoundException
import site.katchup.springboot.global.message.FailMessage
import site.katchup.springboot.repository.MemberRepository

@Component
class MemberFinder(
    private val memberRepository: MemberRepository,
) {

    fun findByIdOrThrow(id: Long): Member {
        return memberRepository.findById(id)
            .orElseThrow { throw EntityNotFoundException(FailMessage.MEMBER_NOT_FOUND) }
    }
}
