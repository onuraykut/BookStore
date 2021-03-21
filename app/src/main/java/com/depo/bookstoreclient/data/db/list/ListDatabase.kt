package com.depo.bookstoreclient.data.db.list

import androidx.room.Database
import androidx.room.RoomDatabase
import com.depo.bookstoreclient.data.model.listeler.Liste
import com.depo.bookstoreclient.data.model.book.Book

@Database(
    entities = [Liste::class],
    version = 1,
    exportSchema = false
)
abstract class ListDatabase : RoomDatabase() {
    abstract fun listDao(): ListDao
}
