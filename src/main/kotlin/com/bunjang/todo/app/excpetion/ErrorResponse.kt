package com.bunjang.todo.app.excpetion

import java.time.LocalDateTime

data class ErrorResponse(
    val code: String,
    val message: String,
    val timeStamp: LocalDateTime = LocalDateTime.now()
)