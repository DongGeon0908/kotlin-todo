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
        return PostCreateResponse(
            post.id!!,
            post.title,
            post.content,
            post.nickname,
            post.status.description
        )
    }

    @Transactional(readOnly = true)
    fun read(id: Long): PostReadResponse {
        val post = postRepository.findById(id)
            .orElseThrow { throw NotExistsException(ErrorCode.NOT_EXISTS_POST) }
        return PostReadResponse(
            post.id!!,
            post.title,
            post.content,
            post.nickname,
            post.status.description
        )
    }

    @Transactional
    fun update(
        id: Long,
        request: PostUpdateRequest
    ): PostUpdateResponse {
        val post = postRepository.findById(id)
            .orElseThrow { throw NotExistsException(ErrorCode.NOT_EXISTS_POST) }
        post.update(request.title, request.content)
        return PostUpdateResponse(
            post.id!!,
            post.title,
            post.content,
            post.nickname,
            post.status.description
        )
    }

    @Transactional(readOnly = true)
    fun readAll(): PostReadAllResponse {
        val posts: ArrayList<PostReadResponse> = ArrayList()

        postRepository.findAll()
            .mapTo(posts) {
                PostReadResponse(
                    it.id!!,
                    it.title,
                    it.content,
                    it.nickname,
                    it.status.description
                )
            }

        return PostReadAllResponse(posts)
    }

    @Transactional
    fun changeStatus(id: Long): PostChangeStatusResponse {
        val post = postRepository.findById(id)
            .orElseThrow { throw NotExistsException(ErrorCode.NOT_EXISTS_POST) }
        post.changeStatus()

        return PostChangeStatusResponse(
            post.id!!,
            post.title,
            post.content,
            post.nickname,
            post.status.description
        )
    }

    @Transactional
    fun delete(id: Long): PostDeleteResponse1 {
        postRepository.deleteById(id)
        return PostDeleteResponse1(id)
    }

}
