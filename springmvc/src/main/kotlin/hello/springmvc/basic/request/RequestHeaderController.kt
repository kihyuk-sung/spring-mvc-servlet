package hello.springmvc.basic.request

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpMethod
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Locale

@RestController
class RequestHeaderController {

    private final val log: Logger = LoggerFactory.getLogger(javaClass)

    @RequestMapping("/headers")
    fun headers(
        request: HttpServletRequest,
        response: HttpServletResponse,
        httpMethod: HttpMethod,
        locale: Locale,
        @RequestHeader headerMap: MultiValueMap<String, String>,
        @RequestHeader("host") host: String,
        @CookieValue(value = "myCookie", required = false) myCookie: String?,
    ): String = "ok"
        .also { log.info("request={}", request) }
        .also { log.info("response={}", response) }
        .also { log.info("httpMethod={}", httpMethod) }
        .also { log.info("locale={}", locale) }
        .also { log.info("headerMap={}", headerMap) }
        .also { log.info("host={}", host) }
        .also { log.info("myCookie={}", myCookie) }

}
