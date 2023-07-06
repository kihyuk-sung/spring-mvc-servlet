package hello.servlet.web.frontcontroller.v1.controller

import hello.servlet.domain.member.IdGenerator
import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import hello.servlet.web.frontcontroller.v1.ControllerV1
import hello.servlet.web.servletmvc.forward
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class MemberSaveControllerV1: ControllerV1 {
    override fun process(request: HttpServletRequest, response: HttpServletResponse) =
        forward("/WEB-INF/views/save-result.jsp", request, response) {
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
        }
}
