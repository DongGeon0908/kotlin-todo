package com.goofy.todo.rest.dto.response

data class PostCreateResponse(
    val id: Long,
    val title: String,
    val content: String,
    val nickname: String,
    val status: String
)
