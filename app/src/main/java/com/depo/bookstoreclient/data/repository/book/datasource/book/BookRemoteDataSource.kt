package com.depo.bookstoreclient.data.repository.book.datasource.book

import com.depo.bookstoreclient.data.model.MainList
import com.depo.bookstoreclient.data.model.book.Book
import com.depo.bookstoreclient.data.model.book.BookList
import retrofit2.Response

interface BookRemoteDataSource {
    suspend fun getBooks(): Response<MainList>
}