package site.katchup.springboot.dto.member.request

data class MemberUpdateRequest(
    val nickname: String,
    val profileMemo: String,
)
