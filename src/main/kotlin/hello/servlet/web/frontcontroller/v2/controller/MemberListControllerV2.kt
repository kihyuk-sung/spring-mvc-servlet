package hello.servlet.web.frontcontroller.v2.controller

import hello.servlet.domain.member.MemberRepository
import hello.servlet.web.frontcontroller.MyView
import hello.servlet.web.frontcontroller.v1.ControllerV1
import hello.servlet.web.frontcontroller.v2.ControllerV2
import hello.servlet.web.servletmvc.forward
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class MemberListControllerV2: ControllerV2 {
    override fun process(request: HttpServletRequest, response: HttpServletResponse): MyView {
        request.setAttribute("members", MemberRepository.findAll())
        return MyView("/WEB-INF/views/members.jsp")
    }
}
