package com.goofy.todo.service

import com.goofy.todo.excpetion.ErrorCode
import com.goofy.todo.excpetion.NotExistsException
import com.goofy.todo.repository.PostRepository
import com.goofy.todo.rest.dto.PostChangeStatusResponse
import com.goofy.todo.rest.dto.PostCreateRequest
import com.goofy.todo.rest.dto.PostCreateResponse
import com.goofy.todo.rest.dto.PostReadAllResponse
import com.goofy.todo.rest.dto.PostReadResponse
import com.goofy.todo.rest.dto.PostUpdateRequest
import com.goofy.todo.rest.dto.PostUpdateResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.goofy.todo.rest.dto.PostDeleteResponse as PostDeleteResponse1

@Service
class PostService(
    private val postRepository: PostRepository
) {
    @Transactional
    fun save(request: PostCreateRequest): PostCreateResponse {
        val instance = com.goofy.todo.entity.Post(request.title, request.content, request.nickname)
        val post = postRepository.save(instance)

        return PostCreateResponse(post)
    }

    @Transactional(readOnly = true)
    fun read(id: Long): PostReadResponse {
        val post = postRepository.findByIdOrNull(id)
            ?: throw NotExistsException(ErrorCode.NOT_EXISTS_POST)

        return PostReadResponse(post)
    }

    @Transactional
    fun update(
        id: Long,
        request: PostUpdateRequest
    ): PostUpdateResponse {
        val post = postRepository.findByIdOrNull(id)
            ?.apply { this.update(request.title, request.content) }
            ?: throw NotExistsException(ErrorCode.NOT_EXISTS_POST)

        return PostUpdateResponse(post)
    }

    @Transactional(readOnly = true)
    fun readAll(): PostReadAllResponse {
        val posts = postRepository.findAll()
            .map { PostReadResponse(it) }

        return PostReadAllResponse(posts)
    }

    @Transactional
    fun changeStatus(id: Long): PostChangeStatusResponse {
        val post = postRepository.findByIdOrNull(id)
            ?.apply { this.changeStatus() }
            ?: throw NotExistsException(ErrorCode.NOT_EXISTS_POST)

        return PostChangeStatusResponse(post)
    }

    @Transactional
    fun delete(id: Long): PostDeleteResponse1 {
        postRepository.deleteById(id)
        return PostDeleteResponse1(id)
    }
}
