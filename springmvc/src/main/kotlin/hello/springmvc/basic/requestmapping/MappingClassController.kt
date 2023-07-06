package hello.springmvc.basic.requestmapping

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mapping/users")
class MappingClassController {

    @GetMapping
    fun user(): String = "get users"

    @PostMapping
    fun addUser(): String = "post users"

    @GetMapping("/{userId}")
    fun findUser(@PathVariable userId: String): String = "get userId = $userId"

    @PatchMapping("/{userId}")
    fun updateUser(@PathVariable userId: String): String = "update userId = $userId"

    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable userId: String): String = "delete userId = $userId"
}
