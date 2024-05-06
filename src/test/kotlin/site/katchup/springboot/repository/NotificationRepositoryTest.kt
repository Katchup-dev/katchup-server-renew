package site.katchup.springboot.repository

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import site.katchup.springboot.entity.Member
import site.katchup.springboot.entity.Notification
import site.katchup.springboot.entity.SocialType

@RepositoryTest
class NotificationRepositoryTest(
    private val notificationRepository: NotificationRepository,
    private val memberRepository: MemberRepository,
) : FunSpec() {

    init {
        test("사용자의 알림 목록을 최신순으로 조회할 수 있다.") {
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
            val notification1 = Notification(
                title = "title1",
                content = "content1",
                isRead = false,
                memberId = savedMember.id!!,
            )
            val notification2 = Notification(
                title = "title2",
                content = "content2",
                isRead = false,
                memberId = savedMember.id!!,
            )
            val notification3 = Notification(
                title = "title3",
                content = "content3",
                isRead = false,
                memberId = savedMember.id!!,
            )
            notification1.createdAt = notification1.createdAt.plusDays(1)
            notification2.createdAt = notification2.createdAt.plusDays(2)
            notification3.createdAt = notification3.createdAt.plusDays(3)
            notificationRepository.saveAll(listOf(notification1, notification2, notification3))

            // when
            val notifications = notificationRepository.findAllByMemberIdOrderByCreatedAtDesc(savedMember.id!!)

            // then
            notifications.size shouldBe 3
            notifications[0].title shouldBe "title3"
            notifications[0].content shouldBe "content3"

            notifications[1].title shouldBe "title2"
            notifications[1].content shouldBe "content2"

            notifications[2].title shouldBe "title1"
            notifications[2].content shouldBe "content1"
        }
    }
}
