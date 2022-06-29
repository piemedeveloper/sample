package com.example.testingapi.api.utils

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}
enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}
sealed class Resources<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?): Resources<T>(data)
    class Error<T>(message: String, data: T? ): Resources<T>(data, message)
    class Loading<T>(data: T? = null): Resources<T>(data)
}
