package com.bunjang.todo.app.rest.controller.support

import com.fasterxml.jackson.annotation.JsonProperty

data class ResponseDto<T>(
    @JsonProperty("data")
    val data: T
)
