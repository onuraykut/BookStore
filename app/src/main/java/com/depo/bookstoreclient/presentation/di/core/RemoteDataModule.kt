package com.depo.bookstoreclient.presentation.di.core

import com.depo.bookstoreclient.data.api.BookService
import com.depo.bookstoreclient.data.repository.book.datasource.book.BookRemoteDataSource
import com.depo.bookstoreclient.data.repository.book.datasourceImpl.book.BookRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideBookRemoteDataSource(bookService: BookService): BookRemoteDataSource {
        return BookRemoteDataSourceImpl(
            bookService
        )
    }
}