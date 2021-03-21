package com.depo.bookstoreclient.presentation.di.core

import com.depo.bookstoreclient.data.repository.book.datasource.book.BookCacheDataSource
import com.depo.bookstoreclient.data.repository.book.datasourceImpl.book.BookCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Provides
    @Singleton
    fun provideBookCacheDataSource(): BookCacheDataSource {
        return BookCacheDataSourceImpl()
    }
}