package hello.servlet.web.frontcontroller.v2.controller

import hello.servlet.web.frontcontroller.MyView
import hello.servlet.web.frontcontroller.v2.ControllerV2
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class MemberFormControllerV2: ControllerV2 {
    override fun process(request: HttpServletRequest, response: HttpServletResponse) =
        MyView("/WEB-INF/views/new-form.jsp")
}
