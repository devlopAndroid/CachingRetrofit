package com.opentechspace.cachingretrofit.Internet

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.getSystemService


class CheckInternet {

    companion object{

        fun isInternetAvailable(context : Context) : Boolean {

            (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
                .run {
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    {
                        return this.getNetworkCapabilities(this.activeNetwork)?.hasCapability(
                            NetworkCapabilities.NET_CAPABILITY_INTERNET
                        ) ?: false
                    }
                    else{
                        (@Suppress("Deprecation")
                                return this.activeNetworkInfo?.isConnected ?:false)
                    }
                }
        }
    }
}