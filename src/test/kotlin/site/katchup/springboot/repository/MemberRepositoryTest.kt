package site.katchup.springboot.repository

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import site.katchup.springboot.entity.Member
import site.katchup.springboot.entity.SocialType

@RepositoryTest
class MemberRepositoryTest(
    private val memberRepository: MemberRepository,
) : FunSpec({

    test("신규 회원을 등록할 수 있다.") {
        // given
        val member = Member(
            name = "name",
            nickname = "nickname",
            socialId = "socialId",
            email = "unan@katchup.site",
            socialType = SocialType.GOOGLE,
            profileMemo = "lineMemo",
            workSpaceId = 1,
            profileImage = "https://katchup.site/image/1",
        )
        val savedMember = memberRepository.save(member)
        val findMember = memberRepository.findById(savedMember.id!!).get()
        findMember.id shouldBe savedMember.id
        findMember.name shouldBe "name"
        findMember.nickname shouldBe "nickname"
        findMember.socialId shouldBe "socialId"
        findMember.socialType shouldBe SocialType.GOOGLE
        findMember.profileMemo shouldBe "lineMemo"
        findMember.workSpaceId shouldBe 1
    }
},)
