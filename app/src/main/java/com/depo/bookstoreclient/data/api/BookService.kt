package com.depo.bookstoreclient.data.api

import com.depo.bookstoreclient.data.model.MainList
import com.depo.bookstoreclient.data.model.book.Book
import com.depo.bookstoreclient.data.model.book.BookList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {
    @GET("mainPage.php")
    suspend fun getPopulerBooks(): Response<MainList>

}