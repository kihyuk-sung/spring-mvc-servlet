package hello.servlet.web.frontcontroller.v2.controller

import hello.servlet.domain.member.IdGenerator
import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import hello.servlet.web.frontcontroller.MyView
import hello.servlet.web.frontcontroller.v2.ControllerV2
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class MemberSaveControllerV2: ControllerV2 {
    override fun process(request: HttpServletRequest, response: HttpServletResponse): MyView {
        val id = IdGenerator.next()
        val username = request.getParameter("username") ?: "defaultName"
        val age = request.getParameter("age").toIntOrNull() ?: 10
        Member(
            id = id,
            username = username,
            age = age,
        )
            .also(MemberRepository::save)
            .let { request.setAttribute("member", it) }

        return MyView("/WEB-INF/views/save-result.jsp")
    }
}
