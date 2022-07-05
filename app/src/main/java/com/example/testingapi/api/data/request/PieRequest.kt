package com.example.testingapi.api.data.request

data class PieRequest(
    val auth: AuthX,
    val request: RequestX,
    val service: String
)