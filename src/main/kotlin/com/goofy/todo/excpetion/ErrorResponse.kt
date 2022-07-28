package com.goofy.todo.excpetion

data class ErrorResponse(
    val errorCode: String,
    val reason: String
) {
    constructor(errorCode: ErrorCode) : this(errorCode.code, errorCode.message)
}
