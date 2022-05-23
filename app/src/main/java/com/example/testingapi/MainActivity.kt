package com.example.testingapi


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testingapi.api.ViewModel.MainViewModel
import com.example.testingapi.api.Adapter.MainAdapter
import com.example.testingapi.api.Adapter.PiesAdapter
import com.example.testingapi.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    val adapter = PiesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        viewModel.pies.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setDataList(it)
        }
        )

        viewModel.errorMessage.observe(this, Observer {
        })

        viewModel.getAllData()
    }
}










