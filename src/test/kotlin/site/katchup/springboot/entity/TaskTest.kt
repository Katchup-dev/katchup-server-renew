package site.katchup.springboot.entity

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import site.katchup.springboot.exception.entity.InvalidEntityArgumentException

class TaskTest : FunSpec() {

    init {
        test("제목이 60글자 초과인 업무는 추가할 수 없다.") {
            val titleLength61 = "a".repeat(61)
            shouldThrow<InvalidEntityArgumentException> {
                Task(
                    title = titleLength61,
                    content = "content",
                    status = TaskStatus.IN_PROGRESS,
                    memberWorkSpaceId = 1,
                )
            }.message shouldBe "유효하지 않은 업무 제목"
        }

        test("내용이 600글자 초과된 업무는 추가할 수 없다.") {
            val content = "a".repeat(601)
            shouldThrow<InvalidEntityArgumentException> {
                Task(
                    title = "title",
                    content = content,
                    status = TaskStatus.IN_PROGRESS,
                    memberWorkSpaceId = 1,
                )
            }.message shouldBe "유효하지 않은 업무 내용"
        }
    }
}
