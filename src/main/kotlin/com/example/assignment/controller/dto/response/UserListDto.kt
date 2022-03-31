package com.example.assignment.controller.dto.response

import com.example.assignment.model.User

data class UserListDto(
    val users: List<UserListItemDto>
) {
    companion object {
        fun new(users: List<User>): UserListDto {
            return UserListDto(
                users = users.map { UserListItemDto.new(it) }
            )
        }
    }
}
