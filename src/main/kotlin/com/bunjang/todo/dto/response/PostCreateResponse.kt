package com.bunjang.todo.dto.response

data class PostCreateResponse(
    val title: String,
    val content: String,
    val nickname: String
)