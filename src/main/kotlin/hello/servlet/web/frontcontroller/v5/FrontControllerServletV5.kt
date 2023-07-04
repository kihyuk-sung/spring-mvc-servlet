package hello.servlet.web.frontcontroller.v5

import hello.servlet.web.frontcontroller.MyView
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3
import hello.servlet.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV5", urlPatterns = ["/front-controller/v5/*"])
class FrontControllerServletV5: HttpServlet() {
    private val handlerMappingMap = mapOf(
        "/front-controller/v5/v3/members/new-form" to MemberFormControllerV3(),
        "/front-controller/v5/v3/members/save" to MemberSaveControllerV3(),
        "/front-controller/v5/v3/members" to MemberListControllerV3(),
    )

    private val handlerAdapters = listOf(
        ControllerV3HandlerAdapter(),
    )

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        val handler = handlerMappingMap[request.requestURI]

        if (handler == null) {
            response.status = HttpServletResponse.SC_NOT_FOUND
            return
        }

        val handlerAdapter = handlerAdapters.findLast { it.supports(handler) }
            ?: throw IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler = $handler")

        val modelView = handlerAdapter.handle(request, response, handler)

        val view = MyView("/WEB-INF/views/${modelView.viewName}.jsp")

        view.render(modelView.model, request, response)
    }
}
