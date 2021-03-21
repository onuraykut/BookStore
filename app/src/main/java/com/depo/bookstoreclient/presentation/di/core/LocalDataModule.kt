package com.depo.bookstoreclient.presentation.di.core

import com.depo.bookstoreclient.data.db.book.BookDao
import com.depo.bookstoreclient.data.db.list.ListDao
import com.depo.bookstoreclient.data.repository.book.datasource.book.BookLocalDataSource
import com.depo.bookstoreclient.data.repository.book.datasourceImpl.book.BookLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideBookLocalDataSource(bookDao: BookDao,listDao: ListDao): BookLocalDataSource {
        return BookLocalDataSourceImpl(bookDao,listDao)
    }
}