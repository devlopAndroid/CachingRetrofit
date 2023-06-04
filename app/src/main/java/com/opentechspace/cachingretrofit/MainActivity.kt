package com.opentechspace.cachingretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.opentechspace.cachingretrofit.Adapter.QuotesAdapter
import com.opentechspace.cachingretrofit.Application.MyApplication
import com.opentechspace.cachingretrofit.ViewModel.QuoteViewModel
import com.opentechspace.cachingretrofit.ViewModel.QuoteViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var quoteViewModel: QuoteViewModel
    lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter : QuotesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        val repository = (application as MyApplication).repository
        quoteViewModel = ViewModelProvider(this,QuoteViewModelFactory(repository))
            .get(QuoteViewModel::class.java)

        quoteViewModel.getLiveData.observe(this) { result ->
            Toast.makeText(this, result.results.size.toString(), Toast.LENGTH_SHORT).show()
            val data = result.results
            recyclerView.setHasFixedSize(true)
            myAdapter = QuotesAdapter(this,data)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = myAdapter
        }
    }
}