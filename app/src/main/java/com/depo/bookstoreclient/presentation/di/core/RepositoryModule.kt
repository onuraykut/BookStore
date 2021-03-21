package com.depo.bookstoreclient.presentation.di.core

import com.depo.bookstoreclient.data.repository.book.BookRepositoryImpl
import com.depo.bookstoreclient.data.repository.book.datasource.book.BookCacheDataSource
import com.depo.bookstoreclient.data.repository.book.datasource.book.BookLocalDataSource
import com.depo.bookstoreclient.data.repository.book.datasource.book.BookRemoteDataSource
import com.depo.bookstoreclient.domain.repository.BookRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideBookRepository(
        bookRemoteDataSource: BookRemoteDataSource,
        bookLocalDataSource: BookLocalDataSource,
        bookCacheDataSource: BookCacheDataSource
    ):BookRepository {
        return BookRepositoryImpl(
            bookRemoteDataSource,
            bookLocalDataSource,
            bookCacheDataSource
        )
    }
}