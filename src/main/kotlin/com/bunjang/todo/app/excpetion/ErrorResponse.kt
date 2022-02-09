package com.bunjang.todo.app.excpetion

import java.time.LocalDateTime

data class ErrorResponse(
    val code: String,
    val message: String,
    val serverDateTime: LocalDateTime = LocalDateTime.now()
) {
    constructor(errorCode: ErrorCode) : this(errorCode.code, errorCode.message)
}