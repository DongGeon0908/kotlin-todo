package com.bunjang.todo.app.rest.controller

import com.bunjang.todo.app.rest.controller.support.RestSupport
import com.bunjang.todo.app.rest.dto.request.PostCreateRequest
import com.bunjang.todo.app.rest.dto.request.PostUpdateRequest
import com.bunjang.todo.app.service.PostService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api("post API")
@RestController
@RequestMapping("api/v1/posts")
class PostController(private val postService: PostService) : RestSupport() {

    @ApiOperation("post를 생성한다")
    @PostMapping
    fun insert(@RequestBody request: PostCreateRequest):
            ResponseEntity<*> = created(postService.save(request))

    @ApiOperation("post를 단건 조회한다")
    @GetMapping("/{postId}")
    fun readOne(@PathVariable postId: Long):
            ResponseEntity<*> = ok(postService.read(postId))

    @ApiOperation("post를 업데이트한다")
    @PatchMapping("/{postId}")
    fun update(@PathVariable postId: Long, @RequestBody request: PostUpdateRequest):
            ResponseEntity<*> = ok(postService.update(postId, request))

    @ApiOperation("post를 전체 조회한다")
    @GetMapping
    fun readAll():
            ResponseEntity<*> = ok(postService.readAll())

    @ApiOperation("post의 상태를 변경한다")
    @PostMapping("/{postId}")
    fun changeStatus(@PathVariable postId: Long):
            ResponseEntity<*> = ok(postService.changeStatus(postId))

    @ApiOperation("post를 삭제한다")
    @DeleteMapping("/{postId}")
    fun delete(@PathVariable postId: Long):
            ResponseEntity<*> = ok(postService.delete(postId))
}