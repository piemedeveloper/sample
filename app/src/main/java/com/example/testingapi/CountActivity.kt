package com.example.testingapi


import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.testingapi.databinding.ActivityCountBinding
import com.example.testingapi.databinding.ActivityFlipBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat

@AndroidEntryPoint
class CountActivity : AppCompatActivity() {
    lateinit var textView : TextView
    private lateinit var binding: ActivityCountBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityCountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textView = binding.textView



        // time count down for 30 seconds,
        // with 1 second as countDown interval
        object : CountDownTimer(50000, 1000) {

            // Callback function, fired on regular interval
            override fun onTick(millisUntilFinished: Long) {
                val simpleDateFormat = SimpleDateFormat("hh:mm:ss")
                val dateString = simpleDateFormat.format(millisUntilFinished)
                binding.textView.setText(String.format(dateString))
               // binding.textView.setText("seconds remaining: " + millisUntilFinished / 1000)
            }

            // Callback function, fired
            // when the time is up
            override fun onFinish() {
                textView.setText("done!")
            }
        }.start()
    }
}










