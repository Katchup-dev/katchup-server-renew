package site.katchup.springboot.global.response

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import site.katchup.springboot.global.message.FailMessage
import site.katchup.springboot.global.message.SuccessMessage

class BaseResponse<T>(
    val message: String,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val data: T?,
) {
    constructor(message: String) : this(message, null)
    companion object {
        fun <T> ok(message: SuccessMessage, data: T): ResponseEntity<BaseResponse<T>> {
            return ResponseEntity.ok(BaseResponse(message.value, data))
        }

        fun <T> created(message: SuccessMessage, data: T): ResponseEntity<BaseResponse<T>> {
            return ResponseEntity.status(HttpStatus.CREATED).body(BaseResponse(message.value, data))
        }

        fun <T> fail(message: FailMessage): BaseResponse<T> {
            return BaseResponse(message.value, null)
        }
    }
}
