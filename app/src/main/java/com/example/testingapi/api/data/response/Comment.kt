package com.example.testingapi.api.data.response

data class Comment(
    val comment: String,
    val creation_datetime: String,
    val first_name: String,
    val id: String,
    val last_name: String,
    val parent_id: String,
    val pie_id: String,
    val piematecount: String,
    val post_at: String,
    val profile_pic: String,
    val profile_status: String,
    val status: String,
    val subcomment: List<Subcomment>,
    val user_id: String,
    val user_name: String
)