package com.bunjang.todo.app.entity

import com.bunjang.todo.app.entity.vo.Status
import javax.persistence.*

@Entity
@Table(name = "post")
class Post(title: String, content: String, nickname: String, status: Status = Status.PROCEEDING) : BaseEntity() {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(name = "post_title")
    val title: String = title

    @Lob
    @Column(name = "post_content")
    val content: String = content

    @Column(name = "post_nickname")
    val nickname: String = nickname

    @Column(name = "post_status")
    @Enumerated(EnumType.STRING)
    val status: Status = status

}