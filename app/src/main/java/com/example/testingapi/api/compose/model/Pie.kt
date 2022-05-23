package com.example.testingapi.api.compose.model

data class Pie(
    val id: Int,
    val user: User,
    val hasImage: Boolean,
    val imageUrl: String?,
    val numComments: Int,
    val numRetweets: Int,
    val numLikes: Int,
    val date: String,
    val text: String,
)
