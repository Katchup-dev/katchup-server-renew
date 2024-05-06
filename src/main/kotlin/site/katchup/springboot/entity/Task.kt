package site.katchup.springboot.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import site.katchup.springboot.exception.entity.InvalidEntityArgumentException
import site.katchup.springboot.global.message.FailMessage

@Entity
class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var title: String,
    var content: String,
    val status: TaskStatus,
    val memberWorkSpaceId: Long,
) : BaseTimeEntity() {

    init {
        validate()
    }

    private fun validate() {
        if (title.length > 60) {
            throw InvalidEntityArgumentException(FailMessage.INVALID_TASK_TITLE)
        }

        if (content.length > 600) {
            throw InvalidEntityArgumentException(FailMessage.INVALID_TASK_CONTENT)
        }
    }
}
