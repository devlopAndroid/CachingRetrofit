package com.opentechspace.cachingretrofit.Repository

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.opentechspace.cachingretrofit.Db.QuoteDatabase
import com.opentechspace.cachingretrofit.Internet.CheckInternet
import com.opentechspace.cachingretrofit.Network.ApiInterface
import com.opentechspace.cachingretrofit.Network.Model

class QuoteRepository(
    private val apiInterface: ApiInterface,
    private val database: QuoteDatabase,
    private val applicationContext: Context
) {

    private val quoteLiveData =  MutableLiveData<Model>()
    val quotes : LiveData<Model> = quoteLiveData
//    get() = quoteLiveData

    suspend fun getData(page : Int) {
        if(CheckInternet.isInternetAvailable(applicationContext))
        {
            val result = apiInterface.getData(page)
            if(result.body()!= null)
            {
                database.quoteDao().insert(result.body()!!.results)
                quoteLiveData.postValue(result.body())
            }
        }
        else
        {
            val offlineData = database.quoteDao().getOfflineData()
            val dataList = Model(offlineData)
            quoteLiveData.postValue(dataList)
        }

    }
}