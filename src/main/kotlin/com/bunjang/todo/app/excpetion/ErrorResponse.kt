package com.bunjang.todo.app.excpetion

data class ErrorResponse(
    val errorCode: String,
    val reason: String
) {
    constructor(errorCode: ErrorCode) : this(errorCode.code, errorCode.message)
}