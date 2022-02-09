package com.bunjang.todo.app.excpetion

import org.springframework.http.HttpStatus

class NotExistsException(errorCode: ErrorCode, status: HttpStatus = HttpStatus.NOT_FOUND) :
    BusinessException(errorCode, status)