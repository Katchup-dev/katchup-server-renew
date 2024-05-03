package site.katchup.springboot.global.message

enum class SuccessMessage(
    val value: String,
) {
    SUCCESS_HEALTH_CHECK("OK"),
    SUCCESS_GET_MEMBER("사용자 정보 조회 성공"),
    SUCCESS_UPDATE_MEMBER("사용자 정보 수정 성공"),
    ;
}
