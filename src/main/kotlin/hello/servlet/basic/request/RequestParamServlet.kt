package hello.servlet.basic.request

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "requestParamServlet", urlPatterns = ["/request-param"])
class RequestParamServlet: HttpServlet() {
    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        println("[전체 파라미터 조회] - start")

        request.parameterNames.asIterator().forEach {
            println("$it = ${request.getParameter(it)}")
        }

        println("[전체 파라미터 조회] - end")
        println()

        println("[단일 파라미터 조회]")
        println("username = ${request.getParameter("username")}")
        println("age = ${request.getParameter("age")}")
        println()

        println("[이름이 같은 복수 파라미터 조회]")
        request.getParameterValues("username")
            .forEach { println("username = $it") }
        println()

        response.writer.write("ok")
    }
}
