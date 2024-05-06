package site.katchup.springboot.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import site.katchup.springboot.dto.member.request.MemberUpdateRequest
import site.katchup.springboot.dto.member.response.MemberResponse
import site.katchup.springboot.global.message.SuccessMessage
import site.katchup.springboot.global.response.BaseResponse
import site.katchup.springboot.service.member.MemberProfileService
import site.katchup.springboot.service.member.MemberService

@ApiControllerV1
class MemberController(
    private val memberService: MemberService,
    private val memberProfileService: MemberProfileService,
) {

    @GetMapping("/members")
    fun getMember(memberId: Long): ResponseEntity<BaseResponse<MemberResponse>> {
        return BaseResponse.ok(SuccessMessage.SUCCESS_GET_MEMBER, memberService.getMemberById(memberId))
    }

    @PatchMapping("/members/{memberId}")
    fun updateMember(
        @PathVariable memberId: Long,
        @RequestBody memberUpdateRequest: MemberUpdateRequest,
    ): ResponseEntity<BaseResponse<Unit>> {
        memberProfileService.update(memberId, memberUpdateRequest)
        return BaseResponse.ok(SuccessMessage.SUCCESS_UPDATE_MEMBER)
    }
}
