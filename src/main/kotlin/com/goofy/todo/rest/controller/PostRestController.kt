package com.goofy.todo.rest.controller

import com.goofy.todo.config.web.MEDIA_TYPE_APPLICATION_JSON_UTF8_VALUE
import com.goofy.todo.rest.controller.support.RestSupport
import com.goofy.todo.rest.dto.PostCreateRequest
import com.goofy.todo.rest.dto.PostUpdateRequest
import com.goofy.todo.service.PostService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
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
class PostRestController(
    private val postService: PostService
) : RestSupport() {
    @ApiOperation(value = "post를 생성한다")
    @PostMapping
    fun insert(
        @Valid @RequestBody request: PostCreateRequest
    ) = postService.save(request).wrapCreated()

    @ApiOperation("post를 단건 조회한다")
    @GetMapping("/{postId}")
    fun readOne(
        @PathVariable postId: Long
    ) = postService.read(postId).wrapOk()

    @ApiOperation("post를 업데이트한다")
    @PatchMapping("/{postId}")
    fun update(
        @PathVariable postId: Long,
        @Valid @RequestBody request: PostUpdateRequest
    ) = postService.update(postId, request).wrapOk()

    @ApiOperation("post를 전체 조회한다")
    @GetMapping
    fun readAll() = postService.readAll().wrapOk()

    @ApiOperation("post의 상태를 변경한다")
    @PostMapping("/{postId}")
    fun changeStatus(
        @PathVariable postId: Long
    ) = postService.changeStatus(postId).wrapOk()

    @ApiOperation("post를 삭제한다")
    @DeleteMapping("/{postId}")
    fun delete(
        @PathVariable postId: Long
    ) = postService.delete(postId).wrapOk()
}
