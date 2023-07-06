package hello.servlet.web.frontcontroller.v1.controller

import hello.servlet.web.frontcontroller.v1.ControllerV1
import hello.servlet.web.servletmvc.forward
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class MemberFormControllerV1: ControllerV1 {
    override fun process(request: HttpServletRequest, response: HttpServletResponse) =
        forward("/WEB-INF/views/new-form.jsp", request, response)
}
