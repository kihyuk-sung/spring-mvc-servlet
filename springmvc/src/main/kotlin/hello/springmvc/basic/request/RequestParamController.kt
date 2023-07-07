package hello.springmvc.basic.request

import hello.springmvc.basic.HelloData
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class RequestParamController {
    private final val log: Logger = LoggerFactory.getLogger(javaClass)

    @RequestMapping("/request-param-v1")
    fun requestParamV1(request: HttpServletRequest, response: HttpServletResponse): Unit = response
        .writer
        .write("ok")
        .also {
            log.info(
                "username={}, age={}",
                request.getParameter("username") ?: "default",
                request.getParameter("age").toIntOrNull() ?: 10,
            )
        }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    fun requestParamV2(
        @RequestParam("username") memberName: String,
        @RequestParam("age") memberAge: Int,
    ): String = "ok"
        .also { log.info("username={}, age={}", memberName, memberAge) }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    fun requestParamV3(
        @RequestParam username: String,
        @RequestParam age: Int,
    ): String = "ok"
        .also { log.info("username={}, age={}", username, age) }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    fun requestParamV4(
        username: String,
        age: Int,
    ): String = "ok"
        .also { log.info("username={}, age={}", username, age) }

    @ResponseBody
    @RequestMapping("/request-param-required")
    fun requestParamRequired(
        @RequestParam(required = true) username: String,
        @RequestParam(required = false) age: Int?,
    ): String = "ok"
        .also { log.info("username={}, age={}", username, age) }

    @ResponseBody
    @RequestMapping("/request-param-default")
    fun requestParamDefault(
        @RequestParam(required = true, defaultValue = "guest") username: String,
        @RequestParam(required = false, defaultValue = "-1") age: Int,
    ): String = "ok"
        .also { log.info("username={}, age={}", username, age) }

    @ResponseBody
    @RequestMapping("/request-param-map")
    fun requestParamMap(
        @RequestParam paramMap: Map<String, String>,
    ): String = "ok"
        .also { log.info("username={}, age={}", paramMap["username"], paramMap["age"]) }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    fun modelAttributeV1(
        @ModelAttribute helloData: HelloData,
    ): String = "ok"
        .also { log.info("username={}, age={}", helloData.username, helloData.age) }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    fun modelAttributeV2(
        helloData: HelloData,
    ): String = "ok"
        .also { log.info("username={}, age={}", helloData.username, helloData.age) }
}
