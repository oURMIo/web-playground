package com.home.web.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @Column(name = "username")
    var username: String = ""
        private set

    @Column(name = "password")
    var password: String = ""
        private set

    constructor()

    constructor(name: String, city: String) {
        this.username = name
        this.password = city
    }
}
