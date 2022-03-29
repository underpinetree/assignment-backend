package com.example.hogehoge.exception

class BadRequestException(
    val httpStatusCode: Int,
    msg: String? = null
) : RuntimeException(msg)
