package site.katchup.springboot.service.member

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import site.katchup.springboot.dto.member.response.MemberResponse

@Service
@Transactional(readOnly = true)
class MemberService(
    private val memberFinder: MemberFinder,
) {
    fun getMemberById(id: Long): MemberResponse {
        val member = memberFinder.findByIdOrThrow(id)
        return MemberResponse(
            memberId = member.id!!,
            nickname = member.nickname,
            email = member.email,
            profileMemo = member.profileMemo,
            profileImage = member.profileImage,
        )
    }
}
