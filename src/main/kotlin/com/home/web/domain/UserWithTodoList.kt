package com.home.web.domain

data class UserWithTodoList(
    var userId: Long,
    var todoList: List<TodoItem>,
)
