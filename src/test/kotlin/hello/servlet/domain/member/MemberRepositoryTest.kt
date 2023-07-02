package hello.servlet.domain.member

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class MemberRepositoryTest: BehaviorSpec({
    afterTest { MemberRepository.clear() }

    given("user with id 1") {
        val member = Member(id = 1, username = "hello", age = 20)
        `when`("save user") {
            MemberRepository.save(member)
            then("you can find this user") {
                MemberRepository.findById(1L) shouldBe Member(id = 1L, username = "hello", age = 20)
            }
        }
    }

    given("2 users are given") {
        val member1 = Member(id = 2L, username = "member1", age = 20)
        val member2 = Member(id = 3L, username = "member2", age = 30)

        `when`("2 users are saved") {
            MemberRepository.save(member1)
            MemberRepository.save(member2)

            then("can find all users") {
                val users = MemberRepository.findAll()
                users shouldHaveSize 2

                users shouldContainAll listOf(
                    Member(id = 2L, username = "member1", age = 20),
                    Member(id = 3L, username = "member2", age = 30),
                )
            }
        }
    }
})
