package site.katchup.springboot.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import site.katchup.springboot.dto.member.response.MemberResponse
import site.katchup.springboot.global.message.SuccessMessage
import site.katchup.springboot.global.response.BaseResponse
import site.katchup.springboot.service.MemberService

@ApiControllerV1
class MemberController(
    private val memberService: MemberService,
) {

    @GetMapping("/members")
    fun getMember(memberId: Long): ResponseEntity<BaseResponse<MemberResponse>> {
        return BaseResponse.ok(SuccessMessage.SUCCESS_GET_MEMBER, memberService.getMemberById(memberId))
    }
}
