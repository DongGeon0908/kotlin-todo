package com.bunjang.todo.app.entity.vo

enum class Status(
    val description: String
) {
    PROCEEDING("진행중"),
    COMPLETED("완료");

    fun change(): Status = if (this == PROCEEDING) COMPLETED else PROCEEDING
}