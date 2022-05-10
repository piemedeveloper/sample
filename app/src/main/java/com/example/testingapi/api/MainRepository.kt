package com.example.testingapi.api

import android.util.Log
import com.example.testingapi.api.data.*
import com.example.testingapi.api.utils.Resource
import retrofit2.HttpException
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val api: PieoneApi
    ) {

     suspend fun getData(): Resource<List<DataX>> {
        return try {
            val response= api.getData(
                MainRequest(
                    auth = Auth(id = "279", token = "mJBUFJviEpP-bgAf7jfHCaHG0tjDdK8J4"),
                    request = Request(),
                    service = "user_suggestion"
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
    }


