package com.depo.bookstoreclient.presentation.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.depo.bookstoreclient.domain.usecase.GetBooksUseCase
import com.depo.bookstoreclient.domain.usecase.UpdateBooksUseCase

class BookViewModel(
    private val  getBooksUseCase: GetBooksUseCase,
    private val updateBooksUseCase: UpdateBooksUseCase
): ViewModel() {

    fun getBooks() = liveData {
        val bookList = getBooksUseCase.execute()
        emit(bookList)
    }

    fun updateBooks() = liveData {
        val bookList = updateBooksUseCase.execute()
        emit(bookList)
    }
}