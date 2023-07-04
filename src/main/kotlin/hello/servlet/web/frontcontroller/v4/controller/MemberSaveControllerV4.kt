package hello.servlet.web.frontcontroller.v4.controller

import hello.servlet.domain.member.IdGenerator
import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import hello.servlet.web.frontcontroller.v4.ControllerV4

class MemberSaveControllerV4: ControllerV4 {
    override fun process(paramMap: Map<String, String>, model: MutableMap<String, Any>): String{
        val member = Member(
            id = IdGenerator.next(),
            username = paramMap["username"] ?: "defaultName",
            age = paramMap["age"]?.toIntOrNull() ?: 10,
        )

        MemberRepository.save(member)

        model["member"] = member
        return "save-result"
    }
}
