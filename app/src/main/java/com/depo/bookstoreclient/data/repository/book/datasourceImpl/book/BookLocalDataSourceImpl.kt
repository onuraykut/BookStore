package com.depo.bookstoreclient.data.repository.book.datasourceImpl.book

import com.depo.bookstoreclient.data.db.book.BookDao
import com.depo.bookstoreclient.data.db.list.ListDao
import com.depo.bookstoreclient.data.model.book.Book
import com.depo.bookstoreclient.data.model.listeler.Liste
import com.depo.bookstoreclient.data.repository.book.datasource.book.BookLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookLocalDataSourceImpl(private val bookDao: BookDao,private val listDao: ListDao): BookLocalDataSource {
    override suspend fun getBooksFromDB(): List<Book> {
        return bookDao.getBooks()
    }

    override suspend fun saveBooksToDB(books: List<Book>) {
        CoroutineScope(Dispatchers.IO).launch {
            bookDao.saveBooks(books)
        }
    }

    override suspend fun getListsFromDB(): List<Liste> {
        return listDao.getLists()
    }

    override suspend fun saveListsToDB(liste: List<Liste>) {
        CoroutineScope(Dispatchers.IO).launch {
            listDao.saveLists(liste)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            bookDao.deleteAllBooks()
        }
    }
}