package site.katchup.springboot.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id

@Entity
class WorkSpace(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null,
    val name: String,
    val description: String,
    val domain: String,
)
