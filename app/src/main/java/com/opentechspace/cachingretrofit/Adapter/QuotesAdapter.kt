package com.opentechspace.cachingretrofit.Adapter

import android.content.Context
import android.content.Intent
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.opentechspace.cachingretrofit.Network.Result
import com.opentechspace.cachingretrofit.R

class QuotesAdapter(private val context:Context,private val result: List<Result>) : RecyclerView.Adapter<QuotesAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val quotetext = itemView.findViewById<TextView>(R.id.quotetext)
        val quoteauthor = itemView.findViewById<TextView>(R.id.quoteauthor)
        val floating = itemView.findViewById<FloatingActionButton>(R.id.floatingActionButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.custom,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val position = result[position]
        holder.quotetext.text = position.content
        holder.quoteauthor.text = position.author
        val mspamble = SpannableString(holder.quoteauthor.text)
         mspamble.setSpan(UnderlineSpan(),0,mspamble.length,0)
          holder.quoteauthor.text = mspamble
        holder.floating.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Hey Check out this Great app:")
            intent.type = "text/plain"
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return result.size
    }
}