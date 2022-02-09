package com.bunjang.todo.app.entity

import com.bunjang.todo.app.entity.vo.Status
import javax.persistence.*

@Entity
@Table(name = "post")
class Post(
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "post_title")
    var title: String,

    @Lob
    @Column(name = "post_content")
    var content: String,

    @Column(name = "post_nickname", unique = true)
    var nickname: String,

    @Column(name = "post_status")
    @Enumerated(EnumType.STRING)
    var status: Status = Status.PROCEEDING
) : BaseEntity() {
    constructor(title: String, content: String, nickname: String) : this(null, title, content, nickname)

    fun update(title: String, content: String) {
        this.title = title
        this.content = content
    }

    fun changeStatus() = this.status.change()
}