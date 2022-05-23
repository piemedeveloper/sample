package com.example.testingapi.api.data.response

data class PieResponse(
    val counted: Int,
    val `data`: List<Data>,
    val lang: String,
    val message: String,
    val offset: Int,
    val success: Int,
    val unread: Int
)