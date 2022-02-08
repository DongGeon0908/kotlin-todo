package com.bunjang.todo.entity

import javax.persistence.*

@Entity
@Table(name = "post")
class Post(title: String, content: String, nickname: String) {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(name = "post_title")
    val title: String = title

    @Column(name = "post_content")
    val content: String = content

    @Column(name = "post_nickname")
    val nickname: String = nickname
}