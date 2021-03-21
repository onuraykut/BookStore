package com.depo.bookstoreclient.presentation.di.book

import com.depo.bookstoreclient.domain.usecase.GetBooksUseCase
import com.depo.bookstoreclient.domain.usecase.UpdateBooksUseCase
import com.depo.bookstoreclient.presentation.book.BookViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class BookModule {
    @BookScope
    @Provides
    fun provideBookViewModelFactory(
        getBooksUseCase: GetBooksUseCase,
        updateBooksUseCase: UpdateBooksUseCase
    ):BookViewModelFactory{
        return BookViewModelFactory(
            getBooksUseCase,
            updateBooksUseCase
        )
    }
}