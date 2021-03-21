package com.depo.bookstoreclient.data.repository.book.datasource.book

import com.depo.bookstoreclient.data.model.MainList
import com.depo.bookstoreclient.data.model.book.Book
import com.depo.bookstoreclient.data.model.listeler.Liste

interface BookCacheDataSource {
    suspend fun getBooksFromCache(): List<Book>
    suspend fun saveBooksToCache(books: List<Book>)
    suspend fun getListsFromCache(): List<Liste>
    suspend fun saveListsToCache(liste: List<Liste>)
}