package com.goofy.todo.rest.dto.request

import javax.validation.constraints.NotBlank

data class PostCreateRequest(
    @field:NotBlank val title: String,
    @field:NotBlank val content: String,
    @field:NotBlank val nickname: String
)
