package com.goofy.todo.rest.dto

data class PostChangeStatusResponse(
    val id: Long,
    val title: String,
    val content: String,
    val nickname: String,
    val status: String
)

data class PostCreateResponse(
    val id: Long,
    val title: String,
    val content: String,
    val nickname: String,
    val status: String
)

data class PostDeleteResponse(
    val id: Long
)

data class PostReadAllResponse(
    val posts: List<PostReadResponse>
)

data class PostReadResponse(
    val id: Long,
    val title: String,
    val content: String,
    val nickname: String,
    val status: String
)

data class PostUpdateResponse(
    val id: Long,
    val title: String,
    val content: String,
    val nickname: String,
    val status: String
)
