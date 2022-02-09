package com.bunjang.todo.app.rest.controller.advice

import com.bunjang.todo.app.excpetion.BusinessException
import com.bunjang.todo.app.excpetion.ErrorCode
import com.bunjang.todo.app.excpetion.ErrorResponse
import com.bunjang.todo.app.rest.controller.support.RestSupport
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestAdvice : RestSupport() {
    @ExceptionHandler(BusinessException::class)
    fun businessException(exception: BusinessException):
            ResponseEntity<*> = error(ErrorResponse(exception.getErrorCode()), exception.getStatus())

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidException(exception: MethodArgumentNotValidException):
            ResponseEntity<*> = error(ErrorResponse(ErrorCode.INVALID_INPUT_VALUE), HttpStatus.BAD_REQUEST)

    @ExceptionHandler(Exception::class)
    fun exception(exception: java.lang.Exception):
            ResponseEntity<*> = error(ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR)
}