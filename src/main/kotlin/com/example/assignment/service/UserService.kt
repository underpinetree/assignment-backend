package com.example.assignment.service

import com.example.assignment.model.User
import com.example.assignment.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun getUsers(): List<User> = userRepository.findAllByOrderByName()

    fun getUsersByNameLike(name: String): List<User> {
        return userRepository.findAllByNameLike(name)
    }

    fun getUserById(id: Long): User? =
        userRepository.findByIdOrNull(id)

    fun addUser(user: User) = userRepository.save(user)
}
