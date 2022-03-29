package com.example.hogehoge.service

import com.example.hogehoge.model.User
import com.example.hogehoge.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun getUsers(): List<User> = userRepository.findAll()

    fun getUserByName(name: String): List<User> =
        userRepository.findByName(name)

    fun getUserById(id: Long): User? =
        userRepository.findByIdOrNull(id)
}
