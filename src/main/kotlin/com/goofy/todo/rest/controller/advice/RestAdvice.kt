package com.goofy.todo.rest.controller.advice

import com.goofy.todo.excpetion.ErrorCode
import com.goofy.todo.excpetion.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestAdvice : com.goofy.todo.rest.controller.support.RestSupport() {
    @ExceptionHandler(com.goofy.todo.excpetion.BusinessException::class)
    fun businessException(exception: com.goofy.todo.excpetion.BusinessException) =
        ErrorResponse(exception.getErrorCode()).wrapError(exception.getStatus())

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidException(exception: MethodArgumentNotValidException) =
        ErrorResponse(ErrorCode.INVALID_INPUT_VALUE)
            .wrapError(HttpStatus.BAD_REQUEST)

    @ExceptionHandler(Exception::class)
    fun exception(exception: java.lang.Exception) =
        ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR)
            .wrapError(HttpStatus.INTERNAL_SERVER_ERROR)
}
