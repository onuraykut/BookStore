package com.depo.bookstoreclient.domain.repository

import com.depo.bookstoreclient.data.model.MainList
import com.depo.bookstoreclient.data.model.book.Book

interface BookRepository {

    suspend fun getBooks(): MainList?
    suspend fun updateBooks():MainList?

}