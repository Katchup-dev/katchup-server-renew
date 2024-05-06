package site.katchup.springboot.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Notification(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    val content: String,
    val isRead: Boolean,
    /**
     * @see Member.id
     */
    val memberId: Long,
) : BaseTimeEntity()
