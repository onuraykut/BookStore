package com.depo.bookstoreclient.data.db.book

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.depo.bookstoreclient.data.model.book.Book

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBooks(books: List<Book>)

    @Query("DELETE FROM book")
    suspend fun deleteAllBooks()

    @Query("SELECT * FROM book")
    suspend fun getBooks(): List<Book>
}