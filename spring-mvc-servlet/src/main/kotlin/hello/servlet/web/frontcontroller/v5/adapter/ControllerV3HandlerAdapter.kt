package hello.servlet.web.frontcontroller.v5.adapter

import hello.servlet.web.frontcontroller.ModelView
import hello.servlet.web.frontcontroller.v3.ControllerV3
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class ControllerV3HandlerAdapter: MyHandlerAdapter {
    override fun supports(handler: Any): Boolean =
        handler is ControllerV3


    override fun handle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): ModelView {
        val controller = handler as ControllerV3

        val paramMap = request.parameterNames
            .asSequence()
            .associateWith { request.getParameter(it) }

        return controller.process(paramMap)
    }
}
