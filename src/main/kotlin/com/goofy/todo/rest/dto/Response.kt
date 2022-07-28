package com.goofy.todo.rest.dto

import com.goofy.todo.entity.Post

data class PostChangeStatusResponse(
    val id: Long,
    val title: String,
    val content: String,
    val nickname: String,
    val status: String
) {
    constructor(post: Post) : this(
        post.id!!,
        post.title,
        post.content,
        post.nickname,
        post.status.description
    )
}

data class PostCreateResponse(
    val id: Long,
    val title: String,
    val content: String,
    val nickname: String,
    val status: String
) {
    constructor(post: Post) : this(
        post.id!!,
        post.title,
        post.content,
        post.nickname,
        post.status.description
    )
}

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
) {
    constructor(post: Post) : this(
        post.id!!,
        post.title,
        post.content,
        post.nickname,
        post.status.description
    )
}

data class PostUpdateResponse(
    val id: Long,
    val title: String,
    val content: String,
    val nickname: String,
    val status: String
) {
    constructor(post: Post) : this(
        post.id!!,
        post.title,
        post.content,
        post.nickname,
        post.status.description
    )
}
