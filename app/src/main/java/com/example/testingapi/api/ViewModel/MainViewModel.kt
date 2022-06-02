package com.example.testingapi.api.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testingapi.api.MainRepository
import com.example.testingapi.api.data.DataX
import com.example.testingapi.api.data.response.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository)  : ViewModel() {


    private val _pies = MutableLiveData<List<Data>>()
    val pies : LiveData<List<Data>> =_pies

   private val _errorMessage = MutableLiveData<String>()
    val errorMessage : LiveData<String> =_errorMessage

init {

    getPies()
}


    fun getPies() {
viewModelScope.launch {
  val response=repository.getPies()

    _pies.value =response.data
    Log.d("PIES","$response")
}
    }

}