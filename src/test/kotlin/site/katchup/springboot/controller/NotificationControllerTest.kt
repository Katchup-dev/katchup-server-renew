package site.katchup.springboot.controller

import io.kotest.assertions.print.print
import io.kotest.core.spec.style.FunSpec
import io.mockk.every
import io.mockk.mockk
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import site.katchup.springboot.dto.notification.response.NotificationListResponse
import site.katchup.springboot.dto.notification.response.NotificationResponse
import site.katchup.springboot.service.NotificationService
import java.time.LocalDateTime

@WebMvcTest
class NotificationControllerTest() : FunSpec() {
    private val notificationService = mockk<NotificationService>(relaxed = true)
    private val mockMvc = MockMvcBuilders.standaloneSetup(
        NotificationController(
            notificationService = notificationService,
        ),
    ).build()

    init {
        test("[GET /notifications] 알림 조회 API Test") {
            // given
            every {
                notificationService.getNotifications(any())
            } returns NotificationListResponse.of(
                listOf(
                    NotificationResponse(
                        id = 1L,
                        title = "test 알림",
                        content = "안녕하세요",
                        isRead = false,
                        createdAt = LocalDateTime.now(),
                    ),
                    NotificationResponse(
                        id = 2L,
                        title = "test 알림2",
                        content = "안녕하세요",
                        isRead = false,
                        createdAt = LocalDateTime.now(),
                    ),
                ),
            )
        }

        this.mockMvc.perform(
            get("/api/v1/notifications")
                .param("memberId", "1"),
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.message").value("알림 목록 조회 성공"))
            .print()
    }
}
