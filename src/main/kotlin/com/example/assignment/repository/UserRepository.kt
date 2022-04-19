package com.example.assignment.repository

import com.example.assignment.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional
interface UserRepository : JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u WHERE lower(u.name) LIKE %:name% ORDER BY u.name")
    fun findAllByNameLike(name: String): List<User>

    fun findAllByOrderByName(): List<User>
}
