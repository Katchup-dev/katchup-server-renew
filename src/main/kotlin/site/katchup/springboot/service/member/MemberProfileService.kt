package site.katchup.springboot.service.member

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import site.katchup.springboot.dto.member.request.MemberUpdateRequest

@Service
class MemberProfileService(
    private val memberFinder: MemberFinder,
) {

    @Transactional
    fun update(memberId: Long, memberUpdateRequest: MemberUpdateRequest) {
        val member = memberFinder.findByIdOrThrow(memberId)
        member.nickname = memberUpdateRequest.nickname
        member.profileMemo = memberUpdateRequest.profileMemo
    }
}
