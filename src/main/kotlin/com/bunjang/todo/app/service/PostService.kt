package com.bunjang.todo.app.service

import com.bunjang.todo.app.rest.dto.request.PostCreateRequest
import com.bunjang.todo.app.rest.dto.response.PostCreateResponse
import com.bunjang.todo.app.entity.Post
import com.bunjang.todo.app.repository.PostRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class PostService(private val postRepository: PostRepository) {
    @Transactional
    fun save(postCreateRequest: PostCreateRequest): PostCreateResponse {
        val instance = Post(postCreateRequest.title, postCreateRequest.content, postCreateRequest.nickname)
        val post = postRepository.save(instance)
        return PostCreateResponse(post.id!!, post.title, post.content, post.nickname, post.status.description)
    }
}