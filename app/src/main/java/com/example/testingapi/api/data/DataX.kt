package com.example.testingapi.api.data

import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("Countfollowers")
    val countfollowers: String,
    @SerializedName("Countpiemates")
    val countpiemates: String,
    @SerializedName("Cover_pic")
    val cover_pic: String,
    @SerializedName("Creation_datetime")
    val creation_datetime: String,
    val email_id: String,
    val first_name: String,
    val follow: String,
    val followstatus: String,
    val last_name: String,
    val post_at: String,

    @SerializedName("Profile_pic")
    val profile_pic: String,
    val profile_status: String,
    val status: String,
    val user_id: String,
    val user_name: String,
    val xmpp_login_user_name: String,
    val xmpp_user_name: String
)