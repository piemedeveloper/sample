package com.example.testingapi

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testingapi.databinding.ActivityFlipBinding
import java.util.*
import java.util.concurrent.TimeUnit


class FlipCardActivity : AppCompatActivity() {

    private var isCancelled = false

    private lateinit var binding: ActivityFlipBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        binding = ActivityFlipBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 60 seconds (1 minute)
        val minute:Long = 1000 * 60 // 1000 milliseconds = 1 second

        // 1 day 2 hours 35 minutes 50 seconds
        val millisInFuture:Long = (minute * 1440) + (minute * 155) + (1000 * 50)

        // Count down interval 1 second
        val countDownInterval:Long = 1000


        binding.buttonStart.setOnClickListener{
            // Start the timer
            timer(millisInFuture,countDownInterval).start()
            it.isEnabled = false
            binding.buttonStart.isEnabled = true

            isCancelled = false
        }


        // Count down timer stop/cancel button
        binding.buttonStop.setOnClickListener{
            // Start the timer
            isCancelled = true

            it.isEnabled = false
            binding.buttonStart.isEnabled = true
        }
    }



    // Method to configure and return an instance of CountDownTimer object
    private fun timer(millisInFuture:Long,countDownInterval:Long):CountDownTimer{
        return object: CountDownTimer(millisInFuture,countDownInterval){
            override fun onTick(millisUntilFinished: Long){
                val timeRemaining = timeString(millisUntilFinished)
                if (isCancelled){
                    binding.textview.text = "${binding.textview.text}\nStopped.(Cancelled)"
                    cancel()
                }else{
                    binding.textview.text = timeRemaining
                }
            }

            override fun onFinish() {
                binding.textview.text = "Done"

                binding.buttonStart.isEnabled = true
                binding.buttonStop.isEnabled = false
            }
        }
    }



    // Method to get days hours minutes seconds from milliseconds
    private fun timeString(millisUntilFinished:Long):String{
        var millisUntilFinished:Long = millisUntilFinished
        val days = TimeUnit.MILLISECONDS.toDays(millisUntilFinished)
        millisUntilFinished -= TimeUnit.DAYS.toMillis(days)

        val hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished)
        millisUntilFinished -= TimeUnit.HOURS.toMillis(hours)

        val minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
        millisUntilFinished -= TimeUnit.MINUTES.toMillis(minutes)

        val seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)

        // Format the string
        return String.format(
            Locale.getDefault(),
            "%02d day: %02d hour: %02d min: %02d sec",
            days,hours, minutes,seconds
        )
    }
}



// Extension function to show toast message
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}