package hello.springmvc.basic.requestmapping

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class MappingController {
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    @RequestMapping(path = ["/hello-basic", "/hello-go"])
    fun helloBasic(): String = "ok"
        .also { log.info("helloBasic") }

    @RequestMapping(path = ["/hello-get-v1"], method = [RequestMethod.GET])
    fun mappingGetV1(): String = "ok"
        .also { log.info("mappingGetV1") }

    @GetMapping("/hello-get-v2")
    fun mappingGetV2(): String = "ok"
        .also { log.info("mappingGetV2") }

    @GetMapping("/mapping/{userId}")
    fun mappingPath(@PathVariable("userId") userId: String): String = "ok"
        .also { log.info("mappingPath userId={}", userId) }

    @GetMapping("/mapping/{userId}/orders/{orderId}")
    fun mappingPath(@PathVariable("userId") userId: String, @PathVariable orderId: Long): String = "ok"
        .also { log.info("mappingPath userId={}, orderId={}", userId, orderId) }

    @GetMapping("/mapping-param", params = ["mode=debug"])
    fun mappingParam(): String = "ok"
        .also { log.info("mappingParam") }

    @GetMapping("/mapping-header", headers = ["mode=debug"])
    fun mappingHeader(): String = "ok"
        .also { log.info("mappingHeader") }

    @PostMapping("/mapping-consume", consumes = ["application/json"])
    fun mappingConsumes(): String = "ok"
        .also { log.info("mappingConsumes") }

    @GetMapping("/mapping-produce", produces = ["text/html"])
    fun mappingProduce(): String = "ok"
        .also { log.info("mappingProduce") }


}
