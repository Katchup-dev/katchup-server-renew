package site.katchup.springboot.controller

import io.kotest.core.spec.style.FunSpec
import io.mockk.every
import io.mockk.mockk
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import site.katchup.springboot.dto.member.response.MemberResponse
import site.katchup.springboot.service.MemberService

@WebMvcTest
class MemberControllerTest() : FunSpec() {
    private val memberService = mockk<MemberService>(relaxed = true)
    private val mockMvc = MockMvcBuilders.standaloneSetup(
        MemberController(
            memberService = memberService,
        ),
    ).build()

    init {
        test("[GET /api/v1/members] 사용자 조회 API Test") {
            every {
                memberService.getMemberById(any())
            } returns MemberResponse(
                memberId = 1L,
                nickname = "unan",
                email = "unan@katchup.site",
                profileMemo = "안녕하세요",
                profileImage = "https://katchup.site/image/1",
            )
            mockMvc.perform(
                get("/api/v1/members")
                    .param("memberId", "1"),
            )
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.message").value("사용자 정보 조회 성공"))
                .andExpect(jsonPath("$.data.memberId").value(1))
                .andExpect(jsonPath("$.data.nickname").value("unan"))
                .andExpect(jsonPath("$.data.email").value("unan@katchup.site"))
                .andExpect(jsonPath("$.data.profileMemo").value("안녕하세요"))
                .andExpect(jsonPath("$.data.profileImage").value("https://katchup.site/image/1"))
        }
    }
}
