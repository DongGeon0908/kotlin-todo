package com.bunjang.todo.app.rest.controller

import com.bunjang.todo.app.rest.controller.support.RestSupport
import com.bunjang.todo.app.rest.dto.request.PostCreateRequest
import com.bunjang.todo.app.rest.dto.request.PostUpdateRequest
import com.bunjang.todo.app.rest.dto.response.*
import com.bunjang.todo.app.service.PostService
import com.bunjang.todo.config.web.MEDIA_TYPE_APPLICATION_JSON_UTF8
import com.bunjang.todo.config.web.MEDIA_TYPE_APPLICATION_JSON_UTF8_VALUE
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@Api(tags = ["post API"], description = "TODO 게시글 API")
@RestController
@RequestMapping(path = ["api/v1/posts"], produces = [MEDIA_TYPE_APPLICATION_JSON_UTF8_VALUE])
class PostRestController(private val postService: PostService) : RestSupport() {

    @ApiOperation(value = "post를 생성한다", response = PostCreateResponse::class)
    @ApiResponse(code = 201, message = "CREATED")
    @PostMapping
    fun insert(@Valid @RequestBody request: PostCreateRequest):
            ResponseEntity<*> = created(postService.save(request))

    @ApiOperation("post를 단건 조회한다", response = PostReadResponse::class)
    @GetMapping("/{postId}")
    fun readOne(@PathVariable postId: Long):
            ResponseEntity<*> = ok(postService.read(postId))

    @ApiOperation("post를 업데이트한다", response = PostUpdateResponse::class)
    @PatchMapping("/{postId}")
    fun update(@PathVariable postId: Long, @Valid @RequestBody request: PostUpdateRequest):
            ResponseEntity<*> = ok(postService.update(postId, request))

    @ApiOperation("post를 전체 조회한다", response = PostReadAllResponse::class)
    @GetMapping
    fun readAll():
            ResponseEntity<*> = ok(postService.readAll())

    @ApiOperation("post의 상태를 변경한다", response = PostChangeStatusResponse::class)
    @PostMapping("/{postId}")
    fun changeStatus(@PathVariable postId: Long):
            ResponseEntity<*> = ok(postService.changeStatus(postId))

    @ApiOperation("post를 삭제한다", response = PostDeleteResponse::class)
    @DeleteMapping("/{postId}")
    fun delete(@PathVariable postId: Long):
            ResponseEntity<*> = ok(postService.delete(postId))
}