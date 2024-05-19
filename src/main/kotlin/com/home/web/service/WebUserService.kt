package com.home.web.service

import com.home.web.domain.WebUser
import com.home.web.exeption.DatabaseException
import com.home.web.repository.WebUserRepository
import java.util.Optional
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class WebUserService(
    @Autowired
    private val webUserRepository: WebUserRepository,
) {

    fun getWebUsers(): List<WebUser> {
        try {
            return webUserRepository.findAll().toList()
        } catch (e: DatabaseException) {
            logger.error { "Got issue in getWebUsers, $e" }
            return listOf()
        }
    }

    fun findById(userId: Long): Optional<WebUser> {
        try {
            return webUserRepository.findById(userId)
        } catch (e: DatabaseException) {
            logger.error { "Got issue in findById(userId:$userId), $e" }
            return Optional.empty()
        }
    }

    fun findByUsername(username: String): Optional<WebUser> {
        try {
            return webUserRepository.findFirstByUsername(username)
        } catch (e: DatabaseException) {
            logger.error { "Got issue in findByUsername(username:$username), $e" }
            return Optional.empty()
        }
    }

    fun createWebUser(username: String, password: String): Optional<WebUser> {
        val webUser = WebUser(username = username, password = password)
        try {
            return Optional.of(webUserRepository.save(webUser))
        } catch (e: DatabaseException) {
            logger.error { "Got issue in createWebUser(username:$username, password:$password), $e" }
            return Optional.empty()
        }
    }

    fun deleteWebUserById(userId: Long) {
        try {
            webUserRepository.deleteById(userId)
        } catch (e: DatabaseException) {
            logger.error { "Got issue in deleteWebUserById, $e" }
        }
    }
}