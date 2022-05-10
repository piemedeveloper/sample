package com.example.testingapi


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.testingapi.databinding.ActivityComposeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComposeActivity : AppCompatActivity() {
    lateinit var textView : TextView
    private lateinit var binding: ActivityComposeBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityComposeBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // time count down for 30 seconds,
        // with 1 second as countDown interval


    }
}








