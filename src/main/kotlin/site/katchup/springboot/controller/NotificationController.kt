package site.katchup.springboot.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import site.katchup.springboot.auth.Auth
import site.katchup.springboot.dto.notification.request.NotificationRequest
import site.katchup.springboot.dto.notification.response.NotificationListResponse
import site.katchup.springboot.dto.notification.response.NotificationResponse
import site.katchup.springboot.global.message.SuccessMessage
import site.katchup.springboot.global.response.BaseResponse
import site.katchup.springboot.service.notification.NotificationService

@ApiControllerV1
class NotificationController(
    private val notificationService: NotificationService,
) {

    @GetMapping("/notifications")
    fun getNotifications(@Auth memberId: Long): ResponseEntity<BaseResponse<NotificationListResponse>> {
        return BaseResponse.ok(SuccessMessage.SUCCESS_GET_NOTIFICATIONS, notificationService.getNotifications(memberId))
    }

    @PostMapping("/notifications")
    fun addNotification(@Auth memberId: Long, @RequestBody request: NotificationRequest): ResponseEntity<BaseResponse<NotificationResponse>> {
        notificationService.addNotification(memberId, request)
        return BaseResponse.ok(SuccessMessage.SUCCESS_ADD_NOTIFICATION)
    }
}
