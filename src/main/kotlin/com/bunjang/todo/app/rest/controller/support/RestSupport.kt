package com.bunjang.todo.app.rest.controller.support

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

abstract class RestSupport {

    protected open fun <T> ok(data: T): ResponseEntity<*> {
        return ResponseEntity
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(data);
    }
}