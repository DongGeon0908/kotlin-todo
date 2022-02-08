package com.bunjang.todo.controller

import com.bunjang.todo.common.RestSupport
import com.bunjang.todo.dto.request.PostCreateRequest
import com.bunjang.todo.service.PostService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/posts")
class PostController(private val postService: PostService) : RestSupport() {

    @PostMapping
    fun read(@RequestBody request: PostCreateRequest): ResponseEntity<*> {
        val response = postService.save(request)
        return ok(response)
    }
}