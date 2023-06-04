package com.opentechspace.cachingretrofit.Db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.opentechspace.cachingretrofit.Network.Result


@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(result : List<Result>)

    @Query("SELECT * FROM Quotes")
    suspend fun getOfflineData() : List<Result>
}