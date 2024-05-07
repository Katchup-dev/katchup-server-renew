package site.katchup.springboot.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import site.katchup.springboot.auth.Auth
import site.katchup.springboot.dto.member.request.MemberAlarmRequest
import site.katchup.springboot.dto.member.request.MemberUpdateRequest
import site.katchup.springboot.dto.member.response.MemberAlarmResponse
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
    fun getMember(@Auth memberId: Long): ResponseEntity<BaseResponse<MemberResponse>> {
        return BaseResponse.ok(SuccessMessage.SUCCESS_GET_MEMBER, memberService.getMemberById(memberId))
    }

    @PatchMapping("/members")
    fun updateMember(
        @Auth memberId: Long,
        @RequestBody memberUpdateRequest: MemberUpdateRequest,
    ): ResponseEntity<BaseResponse<Unit>> {
        memberProfileService.update(memberId, memberUpdateRequest)
        return BaseResponse.ok(SuccessMessage.SUCCESS_UPDATE_MEMBER)
    }

    @PutMapping("/members/alarm")
    fun updateMemberAlarmConsent(
        @Auth memberId: Long,
        @RequestBody request: MemberAlarmRequest,
    ): ResponseEntity<BaseResponse<MemberAlarmResponse>> {
        val response = memberProfileService.updateAlarmConsent(memberId, request)
        return BaseResponse.ok(SuccessMessage.SUCCESS_UPDATE_ALARM_CONSENT, response)
    }
}
