package com.example.assignment.controller.dto.response

import com.example.assignment.model.User
import java.time.LocalDateTime

data class UserListItemDto(
    val id: Long,
    val name: String,
    val url: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun new(user: User): UserListItemDto {
            return UserListItemDto(
                id = user.id,
                name = user.name,
                url = user.url,
                createdAt = user.createdAt,
                updatedAt = user.updatedAt
            )
        }
    }
}
