package com.example.testingapi.api.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testingapi.api.MainRepository
import com.example.testingapi.api.data.DataX
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository)  : ViewModel() {

    private val _dataList = MutableLiveData<List<DataX>>()
    val dataList : LiveData<List<DataX>> =_dataList
   private val _errorMessage = MutableLiveData<String>()
    val errorMessage : LiveData<String> =_errorMessage

init {
    getAllData()
}
    fun getAllData() {
viewModelScope.launch {
  val response=repository.getData()

    _dataList.value =response.data
    Log.d("VIEWMODEL","$response")
}
    }
}