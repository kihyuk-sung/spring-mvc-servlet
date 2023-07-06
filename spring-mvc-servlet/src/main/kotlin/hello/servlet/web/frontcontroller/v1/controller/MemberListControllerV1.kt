package hello.servlet.web.frontcontroller.v1.controller

import hello.servlet.domain.member.MemberRepository
import hello.servlet.web.frontcontroller.v1.ControllerV1
import hello.servlet.web.servletmvc.forward
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class MemberListControllerV1: ControllerV1 {
    override fun process(request: HttpServletRequest, response: HttpServletResponse) =
        forward("/WEB-INF/views/members.jsp", request, response) {
            request.setAttribute("members", MemberRepository.findAll())
        }
}
