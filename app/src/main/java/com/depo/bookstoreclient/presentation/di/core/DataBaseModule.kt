package com.depo.bookstoreclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.depo.bookstoreclient.data.db.book.BookDao
import com.depo.bookstoreclient.data.db.book.BookDatabase
import com.depo.bookstoreclient.data.db.list.ListDao
import com.depo.bookstoreclient.data.db.list.ListDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideBookDataBase(context: Context): BookDatabase {
        return Room.databaseBuilder(context, BookDatabase::class.java,"bookclient").build()
    }
    @Singleton
    @Provides
    fun provideListDataBase(context: Context): ListDatabase {
        return Room.databaseBuilder(context, ListDatabase::class.java,"bookclientlList").build()
    }

    @Singleton
    @Provides
    fun provideBookDao(bookDatabase: BookDatabase): BookDao {
        return bookDatabase.bookDao()
    }

    @Singleton
    @Provides
    fun provideListDao(listDatabase: ListDatabase): ListDao {
        return listDatabase.listDao()
    }
}