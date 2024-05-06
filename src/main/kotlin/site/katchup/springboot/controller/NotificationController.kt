package site.katchup.springboot.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import site.katchup.springboot.dto.notification.response.NotificationListResponse
import site.katchup.springboot.global.message.SuccessMessage
import site.katchup.springboot.global.response.BaseResponse
import site.katchup.springboot.service.NotificationService

@ApiControllerV1
class NotificationController(
    private val notificationService: NotificationService,
) {

    @GetMapping("/notifications")
    fun getNotifications(memberId: Long): ResponseEntity<BaseResponse<NotificationListResponse>> {
        return BaseResponse.ok(SuccessMessage.SUCCESS_GET_NOTIFICATIONS, notificationService.getNotifications(memberId))
    }
}
