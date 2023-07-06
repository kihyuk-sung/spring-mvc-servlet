package hello.servlet.web.frontcontroller.v1

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV1", urlPatterns = ["/front-controller/v1/*"])
class FrontControllerServletV1: HttpServlet() {
    private val controllerMap = mapOf(
        "/front-controller/v1/members/new-form" to MemberFormControllerV1(),
        "/front-controller/v1/members/save" to MemberSaveControllerV1(),
        "/front-controller/v1/members" to MemberListControllerV1(),
    )

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        println("FrontControllerServletV1.service")

        val controller = controllerMap[request.requestURI]
        if (controller == null) {
            response.status = HttpServletResponse.SC_NOT_FOUND
            return
        }
        controller.process(request, response)
    }
}
