package com.example.assignment.repository

import com.example.assignment.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional
interface UserRepository : JpaRepository<User, Long> {
    fun findByNameLike(name: String): List<User>
}
