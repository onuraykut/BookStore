package com.depo.bookstoreclient.data.db.book

import androidx.room.Database
import androidx.room.RoomDatabase
import com.depo.bookstoreclient.data.db.list.ListDao
import com.depo.bookstoreclient.data.model.listeler.Liste
import com.depo.bookstoreclient.data.model.book.Book

@Database(
    entities = [Book::class],
    version = 1,
    exportSchema = false
)
abstract class BookDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
//    abstract fun listDao(): ListDao
}
