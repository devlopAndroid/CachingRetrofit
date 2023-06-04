package com.opentechspace.cachingretrofit.Network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/quotes")
    suspend fun getData(@Query("page") page : Int) : Response<Model>
}