package site.katchup.springboot.dto.member.request

data class MemberAlarmRequest(
    val regularAlarmConsent: Boolean,
    val partnerAlarmConsent: Boolean,
)
