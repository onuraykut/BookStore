package com.depo.bookstoreclient.presentation.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.depo.bookstoreclient.domain.usecase.GetBooksUseCase
import com.depo.bookstoreclient.domain.usecase.UpdateBooksUseCase

class BookViewModelFactory(
    private val getBooksUseCase: GetBooksUseCase,
    private val updateBooksUseCase: UpdateBooksUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BookViewModel(getBooksUseCase, updateBooksUseCase) as T
    }
}