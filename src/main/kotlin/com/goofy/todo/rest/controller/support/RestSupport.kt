package com.goofy.todo.rest.controller.support

import com.goofy.todo.config.web.MEDIA_TYPE_APPLICATION_JSON_UTF8
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

abstract class RestSupport {
    protected open fun <T> ok(data: T) =
        ResponseEntity
            .ok()
            .contentType(MEDIA_TYPE_APPLICATION_JSON_UTF8)
            .body(ResponseDto(data))

    protected open fun <T> created(data: T) =
        ResponseEntity
            .status(HttpStatus.CREATED)
            .contentType(MEDIA_TYPE_APPLICATION_JSON_UTF8)
            .body(ResponseDto(data))

    protected open fun <T> error(data: T, status: HttpStatus) =
        ResponseEntity
            .status(status)
            .contentType(MEDIA_TYPE_APPLICATION_JSON_UTF8)
            .body(data)

    fun <T> T.wrapOk() = ok(this)
    fun <T> T.wrapCreated() = created(this)
    fun <T> T.wrapError(status: HttpStatus) = error(this, status)
}
