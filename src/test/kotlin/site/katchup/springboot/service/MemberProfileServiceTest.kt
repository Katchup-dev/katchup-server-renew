package site.katchup.springboot.service

import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.TestCase
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import site.katchup.springboot.dto.member.request.MemberUpdateRequest
import site.katchup.springboot.entity.Member
import site.katchup.springboot.entity.SocialType

class MemberProfileServiceTest : FunSpec() {

    private lateinit var memberProfileService: MemberProfileService

    override suspend fun beforeEach(testCase: TestCase) {
        memberProfileService = MemberProfileService(
            memberFinder = mockk(relaxed = true),
        )
    }

    init {
        test("[update] 사용자의 닉네임과 프로필 소개를 업데이트 할 수 있다.") {
            var member: Member?
            every {
                memberProfileService.update(
                    1L,
                    MemberUpdateRequest(
                        nickname = "changedNickname",
                        profileMemo = "changedMemo",
                    ),
                )
            } answers {
                member = Member(
                    id = 1L,
                    name = "name",
                    nickname = "changedNickname",
                    socialId = "socialId",
                    email = "katchup@katchup.com",
                    socialType = SocialType.GOOGLE,
                    profileMemo = "changedMemo",
                    workSpaceId = 1,
                    profileImage = "https://katchup.site/image/1",
                )
            }
            member = Member(
                id = 1L,
                name = "name",
                nickname = "nickname",
                socialId = "socialId",
                email = "katchup@katchup.com",
                socialType = SocialType.GOOGLE,
                profileMemo = "lineMemo",
                workSpaceId = 1,
                profileImage = "https://katchup.site/image/1",
            )
            memberProfileService.update(
                1L,
                MemberUpdateRequest(
                    nickname = "changedNickname",
                    profileMemo = "changedMemo",
                ),
            )

            member!!.nickname shouldBe "changedNickname"
            member!!.profileMemo shouldBe "changedMemo"
        }
    }
}
