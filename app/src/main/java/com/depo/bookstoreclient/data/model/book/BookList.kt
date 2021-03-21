package com.depo.bookstoreclient.data.model.book

import com.google.gson.annotations.SerializedName

data class BookList(
    @SerializedName("mainBooks")
    val books: List<Book>
)
