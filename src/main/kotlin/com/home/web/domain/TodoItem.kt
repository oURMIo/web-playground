package com.home.web.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "todo_item")
data class TodoItem(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var todoId: Long,
    @Column(name = "user_id")
    var userId: Long = 0,
    @Column(name = "title")
    var title: String,
    @Column(name = "description")
    var description: String?,
    @Column(name = "completed")
    var isCompleted: Boolean,
)
