package com.goofy.todo.excpetion

enum class ErrorCode(
    val code: String,
    val message: String
) {
    NOT_EXISTS_POST("P-0001", "존재하지 않는 게시물"),
    INVALID_INPUT_VALUE("I-0001", "잘못된 입력"),
    INTERNAL_SERVER_ERROR("E-0001", "예상하지 못한 에러"),
    ;
}
