package hello.servlet.basic

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "helloServlet", urlPatterns = ["/hello"])
class HelloServlet: HttpServlet() {

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        println("HelloServlet.service")
        println("request = $request")
        println("response = $response")

        val username = request.getParameter("username")
        println("username = $username")

        with(response) {
            contentType = "text/plain"
            characterEncoding = "utf-8"
            writer.write("hello $username")
        }
    }

}
