package com.depo.bookstoreclient.presentation.di.core

import com.depo.bookstoreclient.domain.repository.BookRepository
import com.depo.bookstoreclient.domain.usecase.GetBooksUseCase
import com.depo.bookstoreclient.domain.usecase.UpdateBooksUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetBookUseCase(bookRepository: BookRepository):GetBooksUseCase{
        return GetBooksUseCase(bookRepository)
    }

    @Provides
    fun provideUpdateBookUseCase(bookRepository: BookRepository):UpdateBooksUseCase{
        return UpdateBooksUseCase(bookRepository)
    }
}