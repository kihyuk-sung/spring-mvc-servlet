package hello.servlet.basic.request

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "requestHeaderServlet", urlPatterns = ["/request-header"])
class RequestHeaderServlet : HttpServlet() {
    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        printStartLine(request)
        printHeaders(request)
        printHeaderUtils(request)
        printEtc(request)
    }

    private fun printStartLine(request: HttpServletRequest): Unit = with(request) {
        println("--- REQUEST-LINE - start ---")

        println("request.getMethod() = $method") //GET

        println("request.getProtocal() = $protocol") //HTTP/1.1

        println("request.getScheme() = $scheme") //http

        // http://localhost:8080/request-header
        // http://localhost:8080/request-header
        println("request.getRequestURL() = $requestURL")
        // /request-test
        // /request-test
        println("request.getRequestURI() = $requestURI")
        //username=hi
        //username=hi
        println("request.getQueryString() = $queryString")
        println("request.isSecure() = $isSecure") //https 사용 유무

        println("--- REQUEST-LINE - end ---")
        println()
    }

    private fun printHeaders(request: HttpServletRequest): Unit = with(request) {
        println("--- Headers - start ---")

        headerNames.asIterator().forEach {
            println("$it: ${getHeader(it)}")
        }

        println("--- Headers - end ---")
    }

    private fun printHeaderUtils(request: HttpServletRequest): Unit = with(request) {
        println("--- Header 편의 조회 start ---")
        println("[Host 편의 조회]")
        println("request.getServerName() = $serverName") //Host 헤더
        println("request.getServerPort() = $serverPort") //Host 헤더
        println()
        println("[Accept-Language 편의 조회]")
        locales.asIterator().forEach { println("locale = $it") }
        println("request.getLocale() = $locale")
        println()
        println("[cookie 편의 조회]")
        cookies?.forEach { println("${it.name}: ${it.value}") }
        println()
        println("[Content 편의 조회]")
        println("request.getContentType() = $contentType")
        println("request.getContentLength() = $contentLength")
        println("request.getCharacterEncoding() = $characterEncoding")
        println("--- Header 편의 조회 end ---")
        println()
    }

    //기타 정보
    private fun printEtc(request: HttpServletRequest): Unit = with(request) {
        println("--- 기타 조회 start ---")
        println("[Remote 정보]")
        println("request.getRemoteHost() = $remoteHost") //
        println("request.getRemoteAddr() = $remoteAddr") //
        println("request.getRemotePort() = $remotePort") //
        println()
        println("[Local 정보]")
        println("request.getLocalName() = $localName") //
        println("request.getLocalAddr() = $localAddr") //
        println("request.getLocalPort() = $localPort") //
        println("--- 기타 조회 end ---")
        println()
    }
}
