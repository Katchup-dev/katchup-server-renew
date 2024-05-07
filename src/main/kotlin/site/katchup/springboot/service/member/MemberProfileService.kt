package site.katchup.springboot.service.member

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import site.katchup.springboot.dto.member.request.MemberAlarmRequest
import site.katchup.springboot.dto.member.request.MemberUpdateRequest
import site.katchup.springboot.dto.member.response.MemberAlarmResponse

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

    @Transactional
    fun updateAlarmConsent(memberId: Long, request: MemberAlarmRequest): MemberAlarmResponse {
        val member = memberFinder.findByIdOrThrow(memberId)
        member.isRegularAlarmConsentGranted = request.regularAlarmConsent
        member.isPartnerAlarmConsentGranted = request.partnerAlarmConsent
        return MemberAlarmResponse(
            regularAlarmConsent = member.isRegularAlarmConsentGranted,
            partnerAlarmConsent = member.isPartnerAlarmConsentGranted,
        )
    }
}
