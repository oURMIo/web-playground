package com.home.web.service

import com.home.web.domain.WebUser
import com.home.web.exeption.DatabaseException
import com.home.web.repository.UserAppRepository
import java.util.Optional
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class UserAppService(
    @Autowired
    private val userAppRepository: UserAppRepository,
) {

    fun getUsers(): List<WebUser> {
        try {
            return userAppRepository.findAll().toList()
        } catch (e: DatabaseException) {
            logger.error { "Got issue in getUsers, $e" }
            return listOf()
        }
    }

    fun findById(userId: Long): Optional<WebUser> {
        try {
            return userAppRepository.findById(userId)
        } catch (e: DatabaseException) {
            logger.error { "Got issue in getUsers(userId:$userId), $e" }
            return Optional.empty()
        }
    }

    fun findByUsername(username: String): Optional<WebUser> {
        try {
            return userAppRepository.findFirstByUsername(username)
        } catch (e: DatabaseException) {
            logger.error { "Got issue in findByUsername(username:$username), $e" }
            return Optional.empty()
        }
    }

    fun createUser(username: String, password: String): Optional<WebUser> {
        val webUser = WebUser(username = username, password = password)
        try {
            return Optional.of(userAppRepository.save(webUser))
        } catch (e: DatabaseException) {
            logger.error { "Got issue in createUser(username:$username, password:$password), $e" }
            return Optional.empty()
        }
    }

    fun deleteUserById(userId: Long) {
        try {
            userAppRepository.deleteById(userId)
        } catch (e: DatabaseException) {
            logger.error { "Got issue in deleteUserById, $e" }
        }
    }
}