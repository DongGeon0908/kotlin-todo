package com.bunjang.todo.app.rest.dto.request

import javax.validation.constraints.NotBlank

data class PostUpdateRequest(
    @field:NotBlank val title: String,
    @field:NotBlank val content: String
)