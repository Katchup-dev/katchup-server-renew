package site.katchup.springboot.dto.member.response

data class MemberResponse(
    val memberId: Long,
    val nickname: String,
    val email: String,
    val profileMemo: String?,
    val profileImage: String?,
)
