package com.home.web.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "app_user")
data class AppUser(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var userId: Long = 0,
    @Column(name = "username")
    var username: String = "",
    @Column(name = "password")
    var password: String = "",
    @Column(name = "role")
    var role: AppRole = AppRole.USER,
    @Column(name = "creation_date")
    var creationDate: LocalDateTime = LocalDateTime.now(),
) {
    constructor() : this(
        userId = 0,
        username = "",
        password = "",
        role = AppRole.USER,
        creationDate = LocalDateTime.now()
    )
}
