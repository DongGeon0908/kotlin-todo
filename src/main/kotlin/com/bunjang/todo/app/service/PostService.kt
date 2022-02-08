package com.bunjang.todo.app.service

import com.bunjang.todo.app.rest.dto.request.PostCreateRequest
import com.bunjang.todo.app.entity.Post
import com.bunjang.todo.app.repository.PostRepository
import com.bunjang.todo.app.rest.dto.request.PostUpdateRequest
import com.bunjang.todo.app.rest.dto.response.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService(
    private val postRepository: PostRepository
) {

    @Transactional
    fun save(postCreateRequest: PostCreateRequest): PostCreateResponse {
        val instance = Post(postCreateRequest.title, postCreateRequest.content, postCreateRequest.nickname)
        val post = postRepository.save(instance)
        return PostCreateResponse(post.id!!, post.title, post.content, post.nickname, post.status.description)
    }

    @Transactional(readOnly = true)
    fun read(postId: Long): PostReadResponse {
        val post = postRepository.findById(postId).get()

        return PostReadResponse(post.id!!, post.title, post.content, post.nickname, post.status.description)
    }

    @Transactional
    fun update(postId: Long, request: PostUpdateRequest): PostUpdateResponse {
        val post = postRepository.findById(postId).get()
        post.update(request.title, request.content)

        return PostUpdateResponse(post.id!!, post.title, post.content, post.nickname, post.status.description)
    }

    @Transactional(readOnly = true)
    fun readAll(): PostReadAllResponse {

        val posts: ArrayList<PostReadResponse> = ArrayList()

        postRepository.findAll()
            .mapTo(posts) {
                PostReadResponse(it.id!!, it.title, it.content, it.nickname, it.status.description)
            }

        return PostReadAllResponse(posts)
    }

    @Transactional
    fun changeStatus(postId: Long): PostChangeStatusResponse {
        val post = postRepository.findById(postId).get()
        post.changeStatus()

        return PostChangeStatusResponse(post.id!!, post.title, post.content, post.nickname, post.status.description)
    }
}