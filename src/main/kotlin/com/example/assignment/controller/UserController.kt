package com.example.assignment.controller

import com.example.assignment.controller.dto.response.UserListDto
import com.example.assignment.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserController(private val userService: UserService) : RestfulController {
    @GetMapping
    fun getUsers(@RequestParam(value = "name") name: String?): ResponseEntity<UserListDto> {
        if (name != null) {
            val lower = name.lowercase()
            val users = userService.getUsersByNameLike(lower)
            return ResponseEntity.ok().body(UserListDto.new(users))
        } else {
            return ResponseEntity.ok().body(UserListDto.new(userService.getUsers()))
        }
    }
}
