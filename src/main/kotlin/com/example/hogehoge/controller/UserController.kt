package com.example.hogehoge.controller

import com.example.hogehoge.controller.dto.response.UserListDto
import com.example.hogehoge.service.UserService
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
        val users = if (name != null) {
            userService.getUserByName(name)
        } else {
            userService.getUsers()
        }
        return ResponseEntity.ok().body(UserListDto.new(users))
    }
}
