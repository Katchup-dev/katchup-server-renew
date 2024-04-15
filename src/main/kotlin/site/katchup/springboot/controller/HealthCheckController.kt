package site.katchup.springboot.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import site.katchup.springboot.global.message.SuccessMessage
import site.katchup.springboot.global.response.BaseResponse

@RestController
class HealthCheckController {

    @GetMapping("/health")
    fun healthCheck(): ResponseEntity<BaseResponse<String>> {
        return BaseResponse.ok(SuccessMessage.SUCCESS_HEALTH_CHECK, "OK")
    }
}
