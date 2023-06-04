package com.opentechspace.cachingretrofit.Application

import android.app.Application
import com.opentechspace.cachingretrofit.Db.QuoteDatabase
import com.opentechspace.cachingretrofit.Network.ApiInterface
import com.opentechspace.cachingretrofit.Network.ApiService
import com.opentechspace.cachingretrofit.Repository.QuoteRepository

class MyApplication : Application() {

   lateinit var repository: QuoteRepository
    override fun onCreate() {
        super.onCreate()
        val apiInterface = ApiService.getInstance().create(ApiInterface::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        repository = QuoteRepository(apiInterface,database,applicationContext)
    }

}