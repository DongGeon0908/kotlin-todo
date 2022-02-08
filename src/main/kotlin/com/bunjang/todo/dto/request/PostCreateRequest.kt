package com.bunjang.todo.dto.request

data class PostCreateRequest(
    val title: String,
    val content: String,
    val nickname: String
)