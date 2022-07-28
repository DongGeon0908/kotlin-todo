package com.goofy.todo.excpetion

import org.springframework.http.HttpStatus

abstract class BusinessException : RuntimeException {

    private var errorCode: ErrorCode? = null
    private var status: HttpStatus? = null

    constructor() : super()
    constructor(message: String? = null) : super(message)
    constructor(throwable: Throwable) : super(throwable)
    constructor(errorCode: ErrorCode) : super(errorCode.message)
    constructor(errorCode: ErrorCode, status: HttpStatus) : super(errorCode.message) {
        this.errorCode = errorCode
        this.status = status
    }

    fun getErrorCode(): ErrorCode = errorCode!!
    fun getStatus(): HttpStatus = status!!
}
