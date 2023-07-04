package hello.servlet.web.frontcontroller.v4

import hello.servlet.web.frontcontroller.MyView
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV4", urlPatterns = ["/front-controller/v4/*"])
class FrontControllerServletV4: HttpServlet() {
    private val controllerMap = mapOf(
        "/front-controller/v4/members/new-form" to MemberFormControllerV4(),
        "/front-controller/v4/members/save" to MemberSaveControllerV4(),
        "/front-controller/v4/members" to MemberListControllerV4(),
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

        val model = mutableMapOf<String, Any>()

        val viewName = controller.process(paramMap, model)

        val view = MyView("/WEB-INF/views/$viewName.jsp")

        view.render(model, request, response)
    }
}
