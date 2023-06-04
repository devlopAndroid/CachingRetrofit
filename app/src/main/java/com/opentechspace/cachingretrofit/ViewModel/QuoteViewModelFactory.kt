package com.opentechspace.cachingretrofit.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.opentechspace.cachingretrofit.Repository.QuoteRepository

class QuoteViewModelFactory(private val repository: QuoteRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuoteViewModel(repository) as T
    }
}