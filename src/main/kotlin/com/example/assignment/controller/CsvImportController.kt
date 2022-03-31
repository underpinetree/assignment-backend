package com.example.assignment.controller

import com.example.assignment.controller.dto.request.ImportUserDto
import com.example.assignment.exception.BadRequestException
import com.example.assignment.model.User
import com.example.assignment.service.CsvImportService
import com.example.assignment.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.IOException
import java.nio.file.Paths

@RestController
@RequestMapping("/api/v1/import")
class CsvImportController(private val userService: UserService, private val csvImportService: CsvImportService) :
    RestfulController {
    @PostMapping
    fun importUsers(): List<User> {
        try {
            val csvPath = "src/main/resources/data/people.csv"
            println(Paths.get(csvPath).toString())
            val userData = csvImportService.readCsvFile<ImportUserDto>(csvPath)
            val users = userData.map {
                val newUser = if (it.third == "") {
                    User(
                        name = it.first,
                        url = it.second,
                    )
                } else {
                    User(
                        name = it.first + " " + it.second,
                        url = it.third,
                    )
                }
                userService.addUser(newUser)
            }
            return users
        } catch (e: IOException) {

            throw BadRequestException(400, e.toString())
        }
    }
}
