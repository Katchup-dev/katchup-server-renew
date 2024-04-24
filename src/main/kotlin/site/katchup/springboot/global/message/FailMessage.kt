package site.katchup.springboot.global.message

enum class FailMessage(
    val value: String,
) {
    /*
        * 401 UNAUTHORIZED
     */
    INVALID_TOKEN("유효하지 않은 토큰"),

    /*
        * 500 INTERNAL_SERVER_ERROR
    */
    INTERNAL_SERVER_ERROR("서버 내부 오류"),
    ;
}
