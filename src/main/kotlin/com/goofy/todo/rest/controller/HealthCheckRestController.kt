package com.goofy.todo.rest.controller

import com.goofy.todo.config.web.MEDIA_TYPE_APPLICATION_JSON_UTF8_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(produces = [MEDIA_TYPE_APPLICATION_JSON_UTF8_VALUE])
class HealthCheckRestController {
    @GetMapping("health")
    fun health(): String = "hello"
}
