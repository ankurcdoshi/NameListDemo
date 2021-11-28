package com.plantix.namelistdemo.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plantix.namelistdemo.data.datasource.LocalDataSource
import com.plantix.namelistdemo.data.repository.NameListRepository
import com.plantix.namelistdemo.data.datasource.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NameListViewModel: ViewModel() {

    private val mRepository = NameListRepository(LocalDataSource(), RemoteDataSource())

    val loading = MutableLiveData<Boolean>()
    val nameListLiveData = MutableLiveData<List<String>>()

    fun loadNames() {
        loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                mRepository.loadNames()

            }.onSuccess {
                loading.postValue(false)
                nameListLiveData.postValue(it)

            }.onFailure {
                loading.postValue(false)
                Log.e("ViewModel", "Could not load")
            }
        }
    }
}