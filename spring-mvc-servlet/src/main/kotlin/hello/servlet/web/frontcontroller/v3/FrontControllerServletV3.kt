package hello.servlet.web.frontcontroller.v3

import hello.servlet.web.frontcontroller.MyView
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV3", urlPatterns = ["/front-controller/v3/*"])
class FrontControllerServletV3: HttpServlet() {
    private val controllerMap = mapOf(
        "/front-controller/v3/members/new-form" to MemberFormControllerV3(),
        "/front-controller/v3/members/save" to MemberSaveControllerV3(),
        "/front-controller/v3/members" to MemberListControllerV3(),
    )

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        val controller = controllerMap[request.requestURI]

        if (controller == null) {
            response.status = HttpServletResponse.SC_NOT_FOUND
            return
        }

        val paramMap = request.parameterNames
            .asSequence()
            .associateWith { request.getParameter(it) }

        val modelView = controller.process(paramMap)

        val view = MyView("/WEB-INF/views/${modelView.viewName}.jsp")

        view.render(modelView.model, request, response)
    }
}
