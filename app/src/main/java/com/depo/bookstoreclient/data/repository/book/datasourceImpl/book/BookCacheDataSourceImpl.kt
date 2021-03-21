package com.depo.bookstoreclient.data.repository.book.datasourceImpl.book

import com.depo.bookstoreclient.data.model.book.Book
import com.depo.bookstoreclient.data.model.listeler.Liste
import com.depo.bookstoreclient.data.repository.book.datasource.book.BookCacheDataSource

class BookCacheDataSourceImpl: BookCacheDataSource {
    private var bookList = ArrayList<Book>()
    private var listeler = ArrayList<Liste>()
    override suspend fun getBooksFromCache(): List<Book> {
        return bookList
    }

    override suspend fun saveBooksToCache(books: List<Book>) {
        bookList.clear()
        bookList = ArrayList(books)
    }

    override suspend fun getListsFromCache(): List<Liste> {
        return listeler
    }

    override suspend fun saveListsToCache(liste: List<Liste>) {
        listeler.clear()
        listeler = ArrayList(liste)
    }
}