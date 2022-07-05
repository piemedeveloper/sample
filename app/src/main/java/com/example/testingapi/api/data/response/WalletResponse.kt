package com.example.testingapi.api.data.response

data class WalletResponse(
    val `data`: List<DataX>,
    val lang: String,
    val message: String,
    val success: Int
)