package com.example.assignment.exception

class BadRequestException(
    val httpStatusCode: Int,
    msg: String? = null
) : RuntimeException(msg)
