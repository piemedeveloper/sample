package com.example.testingapi.api.data

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PieoneApi {

    @POST("service")
    suspend fun getData(
    @Body mainRequest: MainRequest
    ): DataMan

}