package hello.servlet.web.frontcontroller.v2

import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV2", urlPatterns = ["/front-controller/v2/*"])
class FrontControllerServletV2: HttpServlet() {
    private val controllerMap = mapOf(
        "/front-controller/v2/members/new-form" to MemberFormControllerV2(),
        "/front-controller/v2/members/save" to MemberSaveControllerV2(),
        "/front-controller/v2/members" to MemberListControllerV2(),
    )

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        val controller = controllerMap[request.requestURI]

        if (controller == null) {
            response.status = HttpServletResponse.SC_NOT_FOUND
            return
        }

        val view = controller.process(request, response)
        view.render(request, response)
    }
}
