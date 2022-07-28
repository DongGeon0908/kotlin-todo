package com.goofy.todo.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Lob
import javax.persistence.Table

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
    var status: com.goofy.todo.entity.vo.Status = com.goofy.todo.entity.vo.Status.PROCEEDING
) : BaseEntity() {
    constructor(title: String, content: String, nickname: String) : this(null, title, content, nickname)

    fun update(title: String, content: String) {
        this.title = title
        this.content = content
    }

    fun changeStatus() = this.status.change()
}
