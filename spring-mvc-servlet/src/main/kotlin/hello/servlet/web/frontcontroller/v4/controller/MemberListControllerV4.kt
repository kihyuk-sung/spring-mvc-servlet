package hello.servlet.web.frontcontroller.v4.controller

import hello.servlet.domain.member.MemberRepository
import hello.servlet.web.frontcontroller.v4.ControllerV4

class MemberListControllerV4: ControllerV4 {
    override fun process(paramMap: Map<String, String>, model: MutableMap<String, Any>): String{
        val members = MemberRepository.findAll()

        model["members"] = members

        return "members"
    }
}
