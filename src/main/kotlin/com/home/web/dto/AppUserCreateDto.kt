package com.home.web.dto

import com.home.web.domain.AppRole

data class AppUserCreateDto(
    val username: String,
    val password: String,
    val role: AppRole,
)