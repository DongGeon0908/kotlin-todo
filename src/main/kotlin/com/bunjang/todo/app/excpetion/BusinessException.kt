package com.bunjang.todo.app.excpetion

class BusinessException : RuntimeException {
    constructor() : super()
    constructor(message: String? = null) : super(message)
    constructor(exception: Throwable) : super(exception)
    constructor(errorCode: ErrorCode) : super(errorCode.message)
}