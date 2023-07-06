package hello.servlet.domain.member

import java.util.concurrent.ConcurrentHashMap

object MemberRepository {
    private val store: MutableMap<Long, Member> = ConcurrentHashMap()

    fun save(member: Member): Member = member
        .also { store[it.id] = it }

    fun findById(id: Long): Member? = store[id]

    fun findAll(): List<Member> = store.values.toList()

    fun clear(): Unit = store.clear()
}
