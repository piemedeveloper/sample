package com.example.testingapi.api

import android.util.Log
import com.example.testingapi.api.data.*
import com.example.testingapi.api.data.request.*
import com.example.testingapi.api.data.request.DataX
import com.example.testingapi.api.data.response.Data
import com.example.testingapi.api.utils.Resource
import retrofit2.HttpException
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val api: PieoneApi
    ) {


    suspend fun getPies(): Resource<List<Data>> {
        return try {
            val response= api.getPies(
                PieRequest(
                    auth = AuthX(id = "279", token = "mJBUFJviEpP-bgAf7jfHCaHG0tjDdK8J4"),
                    request = RequestX(
                        data = DataX(
                            "0"
                        )
                    ),
                    service = "get_pies"
                )
            )
            Log.d("SUCCESS","$response")
            Resource.success(response.data)

        } catch (e: Exception){
            return if (e is HttpException) {
                Log.d("ERROR","${e.message()}")
                Resource.error(e.message(), null)

            } else {
                Resource.error(
                    "Couldn't connect to the servers. Check your internet connection, $e",
                    null
                )
            }
        }
    }

    suspend fun getWallet(): Resource<List<com.example.testingapi.api.data.response.DataX>> {
        return try {
            val response= api.getWallet(
                WalletRequest(
                    auth = AuthXX(id = "279", token = "zHnRX9UJgg1-bGaFd44gfdhkFKAwX1u6v"),
                    request = RequestXX(),
                    service = "get_wallet_deposits"
                )
            )
            Log.d("WallSUCCESS","$response")
            Resource.success(response.data)

        } catch (e: Exception){
            return if (e is HttpException) {
                Log.d("ERROR","${e.message()}")
                Resource.error(e.message(), null)

            } else {
                Resource.error(
                    "Couldn't connect to the servers. Check your internet connection, $e",
                    null
                )
            }
        }
    }
    }


