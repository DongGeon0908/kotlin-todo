package com.bunjang.todo.service

import com.bunjang.todo.dto.request.PostCreateRequest
import com.bunjang.todo.dto.response.PostCreateResponse
import com.bunjang.todo.entity.Post
import com.bunjang.todo.repository.PostRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class PostService(private val postRepository: PostRepository) {
    @Transactional
    fun save(postCreateRequest: PostCreateRequest): PostCreateResponse {
        val instance = Post(postCreateRequest.title, postCreateRequest.content, postCreateRequest.nickname)
        val post = postRepository.save(instance)
        return PostCreateResponse(post.title, post.content, post.nickname)
    }
}