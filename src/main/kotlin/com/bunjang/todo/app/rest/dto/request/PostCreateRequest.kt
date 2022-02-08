package com.bunjang.todo.app.rest.dto.request

data class PostCreateRequest(
    val title: String,
    val content: String,
    val nickname: String
)