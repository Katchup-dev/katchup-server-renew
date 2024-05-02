package site.katchup.springboot.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import site.katchup.springboot.dto.member.response.MemberResponse
import site.katchup.springboot.repository.MemberRepository

@Service
@Transactional(readOnly = true)
class MemberService(
    private val memberRepository: MemberRepository,
) {
    fun getMemberById(id: Long): MemberResponse {
        val member = memberRepository.findByIdOrThrow(id)
        return MemberResponse(
            memberId = member.id!!,
            nickname = member.nickname,
            email = member.email,
            profileMemo = member.profileMemo,
            profileImage = member.profileImage,
        )
    }
}
