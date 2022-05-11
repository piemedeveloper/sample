package com.example.testingapi.api.utils

import java.util.concurrent.TimeUnit

object Utility {

    //time to countdown - 1hr - 60secs
    const val TIME_COUNTDOWN: Long = 700000L
    private const val TIME_FORMAT = "%02d:%02d:%02d"


    //convert time to milli seconds
    fun Long.formatTime(): String = String.format(
        TIME_FORMAT,
        TimeUnit.MILLISECONDS.toHours(this),
        TimeUnit.MILLISECONDS.toMinutes(this)% 60,
        TimeUnit.MILLISECONDS.toSeconds(this) % 60
    )

}