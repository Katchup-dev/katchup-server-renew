package site.katchup.springboot.service.memberworkspace

import org.springframework.stereotype.Component
import site.katchup.springboot.entity.MemberWorkSpace
import site.katchup.springboot.exception.entity.EntityNotFoundException
import site.katchup.springboot.global.message.FailMessage
import site.katchup.springboot.repository.MemberWorkSpaceRepository

@Component
class MemberWorkSpaceFinder(
    private val memberWorkSpaceRepository: MemberWorkSpaceRepository,
) {
    fun findMemberWorkSpaceOrThrow(memberId: Long, workSpaceId: Long): MemberWorkSpace {
        return memberWorkSpaceRepository.findByMemberIdAndWorkSpaceId(memberId, workSpaceId)
            ?: throw EntityNotFoundException(FailMessage.MEMBER_WORKSPACE_NOT_FOUND)
    }
}
