package com.depo.bookstoreclient.data.model

import com.depo.bookstoreclient.data.model.book.Book
import com.depo.bookstoreclient.data.model.listeler.Liste
import com.google.gson.annotations.SerializedName

data class MainList(
    @SerializedName("mainBooks")
    val popularBooks: List<Book>,
//    @SerializedName("encokIndirilen")
//    val encokIndirilen: List<Book>,
    @SerializedName("listeler")
    val listeler: List<Liste>,
//    @SerializedName("last")
//    val sonEklenen: List<Book>,
//    @SerializedName("random")
//    val random: List<Book>,
)
