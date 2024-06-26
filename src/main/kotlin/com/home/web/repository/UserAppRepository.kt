package com.home.web.repository

import com.home.web.domain.UserApp
import java.util.Optional
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserAppRepository : CrudRepository<UserApp, Long> {
    fun findByUsername(username: String): List<UserApp>
    fun findFirstByUsername(username: String): Optional<UserApp>
}
