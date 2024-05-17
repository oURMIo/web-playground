package com.home.web.repository

import com.home.web.domain.WebUser
import java.util.Optional
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserAppRepository : CrudRepository<WebUser, Long> {
    fun findByUsername(username: String): List<WebUser>
    fun findFirstByUsername(username: String): Optional<WebUser>
}
