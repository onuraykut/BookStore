package com.depo.bookstoreclient.data.repository.book

import android.util.Log
import com.depo.bookstoreclient.data.model.MainList
import com.depo.bookstoreclient.data.model.book.Book
import com.depo.bookstoreclient.data.model.listeler.Liste
import com.depo.bookstoreclient.data.repository.book.datasource.book.BookCacheDataSource
import com.depo.bookstoreclient.data.repository.book.datasource.book.BookLocalDataSource
import com.depo.bookstoreclient.data.repository.book.datasource.book.BookRemoteDataSource
import com.depo.bookstoreclient.domain.repository.BookRepository
import java.lang.Exception

class BookRepositoryImpl(
    private val bookRemoteDataSource: BookRemoteDataSource,
    private val bookLocalDataSource: BookLocalDataSource,
    private val bookCacheDataSource: BookCacheDataSource
    ): BookRepository {
    override suspend fun getBooks(): MainList? {
        return getBooksFromCache()
    }

    override suspend fun updateBooks(): MainList? {
        val newListOfBooks = getBooksFromAPI()
        bookLocalDataSource.clearAll()
        bookLocalDataSource.saveBooksToDB(newListOfBooks.popularBooks)
        bookCacheDataSource.saveBooksToCache(newListOfBooks.popularBooks)

        bookLocalDataSource.saveListsToDB(newListOfBooks.listeler)
        bookCacheDataSource.saveListsToCache(newListOfBooks.listeler)
        return newListOfBooks
    }

    suspend fun getBooksFromAPI(): MainList{
        lateinit var bookList:MainList
        try {
            val response = bookRemoteDataSource.getBooks()
            val body = response.body()
            if(body!=null) {
                bookList = body
            }
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        return bookList
    }

    suspend fun getBooksFromDB():MainList{
        lateinit var mainList: MainList
        lateinit var bookList:List<Book>
        lateinit var listeler:List<Liste>

        try {
            bookList = bookLocalDataSource.getBooksFromDB()
            listeler = bookLocalDataSource.getListsFromDB()
            mainList = MainList(bookList,listeler)
        }catch (exception:Exception){
            Log.i("MyTags",exception.message.toString())
        }
        if(bookList.size>0){
            return mainList
        }else {
            mainList = getBooksFromAPI()
            bookList = mainList.popularBooks
            listeler = mainList.listeler
            bookLocalDataSource.saveBooksToDB(bookList)
            bookLocalDataSource.saveListsToDB(listeler)
        }
        return mainList
    }

    suspend fun getBooksFromCache():MainList {
        lateinit var mainList: MainList
        lateinit var bookList:List<Book>
        lateinit var listeler:List<Liste>
        try {
            bookList = bookCacheDataSource.getBooksFromCache()
            listeler = bookCacheDataSource.getListsFromCache()
            mainList = MainList(bookList,listeler)
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if(bookList.size>0){
            return mainList
        }else {
            mainList = getBooksFromDB()
            bookCacheDataSource.saveBooksToCache(bookList)
            bookCacheDataSource.saveListsToCache(listeler)
        }
        return mainList
    }

}