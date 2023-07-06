package hello.servlet.web.frontcontroller.v3.controller

import hello.servlet.domain.member.IdGenerator
import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import hello.servlet.web.frontcontroller.ModelView
import hello.servlet.web.frontcontroller.v3.ControllerV3

class MemberSaveControllerV3: ControllerV3 {
    override fun process(paramMap: Map<String, String>): ModelView {
        val member = Member(
            id = IdGenerator.next(),
            username = paramMap["username"] ?: "defaultName",
            age = paramMap["age"]?.toIntOrNull() ?: 10,
        )

        MemberRepository.save(member)

        return ModelView("save-result", mapOf("member" to member))
    }
}
