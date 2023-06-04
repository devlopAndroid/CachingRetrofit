package com.opentechspace.cachingretrofit.Db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.opentechspace.cachingretrofit.Network.Result


@Database(entities = [Result::class], version = 1, exportSchema = false)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quoteDao()  : QuoteDao
    companion object
    {
        private var Instance : QuoteDatabase? = null

        fun getDatabase(context: Context) : QuoteDatabase{
            synchronized(this){
                if(Instance == null)
                {
                    Instance = Room.databaseBuilder(context,QuoteDatabase::class.java,
                        "Quotes")
                        .build()
                }
            }
            return Instance!!
        }
    }
}