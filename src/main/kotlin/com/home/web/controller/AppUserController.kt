package com.home.web.controller

import com.home.web.domain.AppUser
import com.home.web.dto.AppUserCreateDto
import com.home.web.dto.AppUserEditDto
import com.home.web.service.AppUserService
import java.util.Optional
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class AppUserController(
    @Autowired private val appUserService: AppUserService,
) {
    private val logger = KotlinLogging.logger { AppUserController::class.java }

    @GetMapping
    fun getAppUsers(): List<AppUser> {
//        TODO fix method
        logger.trace { "Invoke in getAppUsers" }
        return appUserService.getAppUsers()
    }

    @GetMapping("/{id}")
    fun getAppUserById(
        @PathVariable(name = "id") userId: Long,
    ): ResponseEntity<out Any> {
        logger.trace { "Invoke in getAppUserById(id:$userId)" }
        val webUser = appUserService.findAppUserById(userId)
        return if (webUser.isPresent) {
            ResponseEntity(webUser, HttpStatus.OK)
        } else {
            ResponseEntity("User not found", HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping
    fun createAppUser(@RequestBody appUserCreateDto: AppUserCreateDto): Optional<AppUser> {
        logger.trace { "Invoke createAppUser(appUserCreateDto:$appUserCreateDto)" }
        return appUserService.createAppUser(
            username = appUserCreateDto.username,
            password = appUserCreateDto.password,
            role = appUserCreateDto.role
        )
    }

    @DeleteMapping("/{id}")
    fun deleteAppUser(
        @PathVariable(name = "id") userId: Long,
    ): String {
        logger.trace { "Invoke deleteAppUser(id:$userId)" }
        appUserService.deleteAppUserById(userId)
        return STATUS_DONE
    }

    @PostMapping("/{id}")
    fun editAppUser(
        @PathVariable(name = "id") userId: Long, @RequestBody appUserEditDto: AppUserEditDto,
    ): AppUser {
        logger.trace { "Invoke editAppUser(id:$userId,appUserEditDto:$appUserEditDto)" }
        return appUserService.updateAppUser(
            userId = userId,
            username = appUserEditDto.username,
            password = appUserEditDto.password,
            role = appUserEditDto.role
        )
    }
}

private const val STATUS_DONE = "DONE"