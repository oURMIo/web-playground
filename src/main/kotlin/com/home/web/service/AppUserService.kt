package com.home.web.service

import com.home.web.domain.AppRole
import com.home.web.domain.AppUser
import com.home.web.exeption.AppUserNotFoundException
import com.home.web.exeption.DatabaseException
import com.home.web.repository.AppUserRepository
import java.util.Optional
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AppUserService(
    @Autowired
    private val appUserRepository: AppUserRepository,
) {
    private val logger = KotlinLogging.logger { AppUserService::class.java }

    fun getAppUsers(): List<AppUser> {
        try {
            return appUserRepository.findAll().toList()
        } catch (e: DatabaseException) {
            logger.error { "Got issue in getUsers, $e" }
            return listOf()
        }
    }

    fun findAppUserById(userId: Long): Optional<AppUser> {
        try {
            return appUserRepository.findById(userId)
        } catch (e: DatabaseException) {
            logger.error { "Got issue in getUsers(userId:$userId), $e" }
            return Optional.empty()
        }
    }

    fun findAppUserByUsername(username: String): Optional<AppUser> {
        try {
            return appUserRepository.findFirstByUsername(username)
        } catch (e: DatabaseException) {
            logger.error { "Got issue in findByUsername(username:$username), $e" }
            return Optional.empty()
        }
    }

    fun createAppUser(username: String, password: String, role: AppRole): Optional<AppUser> {
        val appUser = AppUser(
            username = username,
            password = password,
            role = role
        )
        try {
            return Optional.of(appUserRepository.save(appUser))
        } catch (e: DatabaseException) {
            logger.error { "Got issue in createUser(username:$username, password:$password), $e" }
            return Optional.empty()
        }
    }

    fun updateAppUser(userId: Long, username: String?, password: String?, role: AppRole?): AppUser {
        val appUser: AppUser = appUserRepository.findById(userId)
            .orElseThrow { AppUserNotFoundException("Don't have user with id:$userId") }
        if (username != null && username != "") {
            appUser.username = username
        }
        if (password != null && password != "") {
            appUser.password = password
        }
        if (role != null) {
            appUser.role = role
        }
        return appUserRepository.save(appUser)
    }

    fun deleteAppUserById(userId: Long) {
        try {
            appUserRepository.deleteById(userId)
        } catch (e: DatabaseException) {
            logger.error { "Got issue in deleteUserById, $e" }
        }
    }
}