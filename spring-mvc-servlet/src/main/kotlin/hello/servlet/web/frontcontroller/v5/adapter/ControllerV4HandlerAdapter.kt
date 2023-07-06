package hello.servlet.web.frontcontroller.v5.adapter

import hello.servlet.web.frontcontroller.ModelView
import hello.servlet.web.frontcontroller.v4.ControllerV4
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class ControllerV4HandlerAdapter: MyHandlerAdapter {
    override fun supports(handler: Any): Boolean =
        handler is ControllerV4


    override fun handle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): ModelView {
        val controller = handler as ControllerV4

        val paramMap = request.parameterNames
            .asSequence()
            .associateWith { request.getParameter(it) }

        val model = mutableMapOf<String, Any>()
        val viewName = controller.process(paramMap, model)

        return ModelView(
            viewName = viewName,
            model = model,
        )
    }
}
