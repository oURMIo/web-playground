package com.home.web.repository

import com.home.web.domain.AppUser
import java.util.Optional
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserAppRepository : CrudRepository<AppUser, Long> {
    fun findByUsername(username: String): List<AppUser>
    fun findFirstByUsername(username: String): Optional<AppUser>
}
