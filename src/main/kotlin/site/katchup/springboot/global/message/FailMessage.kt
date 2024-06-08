package site.katchup.springboot.global.message

enum class FailMessage(
    val value: String,
) {
    /*
        * 400 BAD REQUEST
    */

    INVALID_PARAMETER("잘못된 요청 파라미터"),
    INVALID_TASK_TITLE("유효하지 않은 업무 제목"),
    INVALID_TASK_CONTENT("유효하지 않은 업무 내용"),

    /*
        * 401 UNAUTHORIZED
     */
    INVALID_TOKEN("유효하지 않은 토큰"),

    /*
        * 404 NOT FOUND
    */
    MEMBER_NOT_FOUND("해당 사용자를 찾을 수 없음"),
    MEMBER_WORKSPACE_NOT_FOUND("해당 사용자 또는 워크스페이스를 찾을 수 없음"),
    TASK_NOT_FOUND("해당 업무를 찾을 수 없음"),

    /*
        * 500 INTERNAL_SERVER_ERROR
    */
    INTERNAL_SERVER_ERROR("서버 내부 오류"),
    FCM_SEND_ERROR("FCM 전송 오류"),
    ;
}
