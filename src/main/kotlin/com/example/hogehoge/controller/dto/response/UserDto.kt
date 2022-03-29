package com.example.hogehoge.controller.dto.response

import com.example.hogehoge.model.User
import java.time.LocalDateTime

data class UserDto(
    val id: Long,
    val name: String,
    val icon: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun new(user: User): UserDto {
            return UserDto(
                id = user.id,
                name = user.name,
                icon = user.icon,
                createdAt = user.createdAt,
                updatedAt = user.updatedAt
            )
        }
    }
}
