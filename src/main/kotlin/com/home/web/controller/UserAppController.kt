package com.home.web.controller

import com.home.web.domain.WebUser
import com.home.web.dto.WebUserAppDto
import com.home.web.service.UserAppService
import java.util.Optional
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("/api/users")
class UserAppController(
    @Autowired private val userAppService: UserAppService,
) {

    @GetMapping("", "/")
    fun checkStatus(): String = WORK_STATUS


    @GetMapping("/get")
    fun getUsers(): List<WebUser> {
        logger.debug { "Invoke in getUsers" }
        return userAppService.getUsers()
    }

    @GetMapping("/get-user")
    fun getUserById(
        @RequestParam("userId") userId: Long,
    ): ResponseEntity<out Any> {
        logger.debug { "Invoke in getUserById(userId:$userId)" }
        val userApp = userAppService.findById(userId)
        return if (userApp.isPresent) {
            ResponseEntity(userApp, HttpStatus.OK)
        } else {
            ResponseEntity("User not found", HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping("/get-user-by-name")
    fun getUserByUsername(
        @RequestParam("username") username: String,
    ): ResponseEntity<out Any> {
        logger.debug { "Invoke in getUserByUsername(username:$username)" }
        val userApp = userAppService.findByUsername(username)
        return if (userApp.isPresent) {
            ResponseEntity(userApp, HttpStatus.OK)
        } else {
            ResponseEntity("User not found", HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping("/create")
    fun createUser(@RequestBody webUserAppDto: WebUserAppDto): Optional<WebUser> {
        logger.debug { "Invoke createUser(webUserAppDto:$webUserAppDto)" }
        return userAppService.createUser(webUserAppDto.username, webUserAppDto.password)
    }

    @GetMapping("/delete")
    fun deleteUser(@RequestParam("userId") userId: Long): String {
        logger.debug { "Invoke deleteUser(userId:$userId)" }
        userAppService.deleteUserById(userId)
        return DONE_STATUS
    }
}

private const val WORK_STATUS = "WORKING"
private const val DONE_STATUS = "DONE"
