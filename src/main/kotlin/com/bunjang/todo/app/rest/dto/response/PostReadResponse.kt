package com.bunjang.todo.app.rest.dto.response

data class PostReadResponse(
    val id: Long,
    val title: String,
    val content: String,
    val nickname: String,
    val status: String
)