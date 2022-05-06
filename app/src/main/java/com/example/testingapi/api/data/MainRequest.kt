package com.example.testingapi.api.data

data class MainRequest(
    val auth: Auth,
    val request: Request,
    val service: String
)