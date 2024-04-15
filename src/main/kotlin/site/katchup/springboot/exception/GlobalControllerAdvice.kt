package site.katchup.springboot.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import site.katchup.springboot.config.getLogger
import site.katchup.springboot.exception.base.KatchupException
import site.katchup.springboot.global.response.BaseResponse

@RestControllerAdvice
class GlobalControllerAdvice {

    private val log = getLogger()

    @ExceptionHandler(KatchupException::class)
    fun handleBadRequestException(exception: KatchupException): ResponseEntity<BaseResponse<Unit>> {
        return BaseResponse.fail(exception.httpStatus, exception.failMessage)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(exception: Exception): ResponseEntity<BaseResponse<Unit>> {
        log.error(exception.message)
        return BaseResponse.fail(exception)
    }
}
