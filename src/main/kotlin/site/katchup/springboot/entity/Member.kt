package site.katchup.springboot.entity

import jakarta.persistence.Entity
import jakarta.persistence.EnumType.STRING
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val socialId: String,
    val nickname: String,
    val email: String,
    @Enumerated(STRING)
    val socialType: SocialType,
    val profileMemo: String?,
    val workSpaceId: Long,
    val profileImage: String?,
)
