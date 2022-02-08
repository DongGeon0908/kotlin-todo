package com.bunjang.todo.app.rest.controller

import com.bunjang.todo.app.rest.controller.support.RestSupport
import com.bunjang.todo.app.rest.dto.request.PostCreateRequest
import com.bunjang.todo.app.rest.dto.request.PostUpdateRequest
import com.bunjang.todo.app.service.PostService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/posts")
class PostController(private val postService: PostService) : RestSupport() {

    @PostMapping
    fun insert(@RequestBody request: PostCreateRequest):
            ResponseEntity<*> = created(postService.save(request))

    @GetMapping("/{postId}")
    fun readOne(@PathVariable postId: Long):
            ResponseEntity<*> = ok(postService.read(postId))

    @PatchMapping("/{postId}")
    fun update(@PathVariable postId: Long, @RequestBody request: PostUpdateRequest):
            ResponseEntity<*> = ok(postService.update(postId, request))

    @GetMapping
    fun readAll():
            ResponseEntity<*> = ok(postService.readAll())

    @PostMapping("/{id}")
    fun changeStatus(@PathVariable postId: Long):
            ResponseEntity<*> = ok(postService.changeStatus(postId))
}