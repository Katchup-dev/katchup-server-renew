package site.katchup.springboot.dto.member.response

data class MemberAlarmResponse(
    val regularAlarmConsent: Boolean,
    val partnerAlarmConsent: Boolean,
)
