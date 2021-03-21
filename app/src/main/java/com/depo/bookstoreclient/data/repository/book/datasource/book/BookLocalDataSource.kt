package com.depo.bookstoreclient.data.repository.book.datasource.book

import com.depo.bookstoreclient.data.model.MainList
import com.depo.bookstoreclient.data.model.book.Book
import com.depo.bookstoreclient.data.model.listeler.Liste
import retrofit2.Response

interface BookLocalDataSource {
    suspend fun getBooksFromDB(): List<Book>
    suspend fun saveBooksToDB(book: List<Book>)
    suspend fun getListsFromDB(): List<Liste>
    suspend fun saveListsToDB(list: List<Liste>)
    suspend fun clearAll()

}