package site.katchup.springboot.repository

import org.springframework.data.jpa.repository.JpaRepository
import site.katchup.springboot.entity.MemberWorkSpace

interface MemberWorkSpaceRepository : JpaRepository<MemberWorkSpace, Long> {
    fun findByMemberIdAndWorkSpaceId(memberId: Long, workSpaceId: Long): MemberWorkSpace?
}
