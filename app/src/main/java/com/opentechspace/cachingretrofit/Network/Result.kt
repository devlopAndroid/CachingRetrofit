package com.opentechspace.cachingretrofit.Network

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Quotes")
data class Result(
    @PrimaryKey
    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
//    val tags: List<String>
)