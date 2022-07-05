package com.example.testingapi.api.ViewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testingapi.api.MainRepository
import com.example.testingapi.api.data.response.Data
import com.example.testingapi.api.data.response.DataX
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository)  : ViewModel() {

    private var _pies: MutableLiveData<List<Data>> = MutableLiveData<List<Data>>()
    var pies: LiveData<List<Data>> = _pies

    private var _wallet: MutableLiveData<List<DataX>> = MutableLiveData<List<DataX>>()
    var wallet: LiveData<List<DataX>> = _wallet

    var isLoading = mutableStateOf(false)
//
//    private val _pies = MutableLiveData<List<Data>>()
//    val pies : LiveData<List<Data>> =_pies

   private val _errorMessage = MutableLiveData<String>()
    val errorMessage : LiveData<String> =_errorMessage

init {
    getWallet()
    //getPies()
}


    fun getPies() {
viewModelScope.launch {
  val response=repository.getPies()

    _pies.value =response.data
    Log.d("PIEESS","$response")
}
    }

    fun getWallet() {
        viewModelScope.launch {
            val response=repository.getWallet()

            _wallet.value =response.data
            Log.d("WALLET","$response")
        }
    }
//    suspend fun getUserData(): Resouce<List<UserResponse>> {
//        val result = repository.getPies()
//        if (result is Resouce.Success) {
//            isLoading.value = true
//            _getUserData.value = result.data!!
//        }
//
//        return result
//    }
}