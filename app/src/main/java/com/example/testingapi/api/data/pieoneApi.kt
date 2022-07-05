package com.example.testingapi.api.data

import com.example.testingapi.api.data.request.PieRequest
import com.example.testingapi.api.data.request.WalletRequest
import com.example.testingapi.api.data.response.PieResponse
import com.example.testingapi.api.data.response.WalletResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PieoneApi {

    @POST("service")
    suspend fun getWallet(
    @Body walletRequest: WalletRequest
    ): WalletResponse

    @POST("service")
    suspend fun getPies(
        @Body pieRequest: PieRequest
    ): PieResponse

}