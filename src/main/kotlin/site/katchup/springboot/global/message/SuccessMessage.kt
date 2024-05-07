package site.katchup.springboot.global.message

enum class SuccessMessage(
    val value: String,
) {
    SUCCESS_HEALTH_CHECK("OK"),
    SUCCESS_GET_MEMBER("사용자 정보 조회 성공"),
    SUCCESS_UPDATE_MEMBER("사용자 정보 수정 성공"),
    SUCCESS_GET_NOTIFICATIONS("알림 목록 조회 성공"),
    SUCCESS_ADD_NOTIFICATION("알림 추가 성공"),
    SUCCESS_ADD_TASK("업무 추가 성공"),
    SUCCESS_UPDATE_TASK("업무 수정 성공"),
    SUCCESS_GET_TASK("업무 조회 성공"),
    SUCCESS_UPDATE_ALARM_CONSENT("알림 수신 동의 변경 성공"),

    ;
}
