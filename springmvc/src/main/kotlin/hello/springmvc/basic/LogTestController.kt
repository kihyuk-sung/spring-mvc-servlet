package hello.springmvc.basic

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LogTestController {
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    @RequestMapping("/log-test")
    fun logTest(): String = "ok"
        .also {
            val name = "Spring"
            println("name = $name")
            log.trace("trace log={}", name)
            log.debug("debug log={}", name)
            log.info("info log={}", name)
            log.warn("warn log={}", name)
            log.error("error log={}", name)
        }

}
