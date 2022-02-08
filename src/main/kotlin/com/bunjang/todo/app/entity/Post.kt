package com.bunjang.todo.app.entity

import com.bunjang.todo.app.entity.vo.Status
import javax.persistence.*

@Entity
@Table(name = "post")
class Post(
    title: String,
    content: String,
    nickname: String
) : BaseEntity() {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "post_title")
    var title: String = title

    @Lob
    @Column(name = "post_content")
    var content: String = content

    @Column(name = "post_nickname", unique = true)
    var nickname: String = nickname

    @Column(name = "post_status")
    @Enumerated(EnumType.STRING)
    var status: Status = Status.PROCEEDING

    fun update(title: String, content: String) {
        this.title = title
        this.content = content
    }

    fun changeStatus() {
        this.status.change();
    }
}