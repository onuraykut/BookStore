package com.depo.bookstoreclient.data.repository.book.datasourceImpl.book

import com.depo.bookstoreclient.data.api.BookService
import com.depo.bookstoreclient.data.model.MainList
import com.depo.bookstoreclient.data.model.book.BookList
import com.depo.bookstoreclient.data.repository.book.datasource.book.BookRemoteDataSource
import retrofit2.Response

class BookRemoteDataSourceImpl(private val  bookService: BookService): BookRemoteDataSource {
    override suspend fun getBooks(): Response<MainList> {
        return bookService.getPopulerBooks()
    }
}