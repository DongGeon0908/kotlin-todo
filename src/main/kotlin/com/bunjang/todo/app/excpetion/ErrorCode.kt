package com.bunjang.todo.app.excpetion

enum class ErrorCode(
    val code: String,
    val message: String
) {
    INTERNAL_SERVER_ERROR("E-I0001", "internal server error")
}