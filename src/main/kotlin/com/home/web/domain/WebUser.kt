package com.home.web.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "web_users")
data class WebUser(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,

    @Column(name = "username")
    var username: String,

    @Column(name = "password")
    var password: String,

    @Column(name = "role")
    var role: String = AppRole.USER.toString(),
)
