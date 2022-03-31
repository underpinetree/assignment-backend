package com.example.assignment.controller

import com.example.assignment.exception.BadRequestException
import com.example.assignment.exception.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

interface RestfulController {
    @ExceptionHandler(BadRequestException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun badRequest(e: BadRequestException): Map<String, String?> =
        mapOf("status" to e.httpStatusCode.toString(), "message" to e.message)

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun notFound(e: NotFoundException): String? =
        e.message
}
