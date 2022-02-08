package com.bunjang.todo.app.rest.dto.request

data class PostUpdateRequest(
    val title: String,
    val content: String
)