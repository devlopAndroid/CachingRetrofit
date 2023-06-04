package com.opentechspace.cachingretrofit.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.opentechspace.cachingretrofit.Application.MyApplication
import com.opentechspace.cachingretrofit.Network.Model
import com.opentechspace.cachingretrofit.Repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteViewModel(private val repository: QuoteRepository) : ViewModel(){

    private val page = 3;
    init {
        viewModelScope.launch (Dispatchers.IO){
            repository.getData(page)
        }
    }

    val getLiveData : LiveData<Model> = repository.quotes
//    get() = repository.quotes

}