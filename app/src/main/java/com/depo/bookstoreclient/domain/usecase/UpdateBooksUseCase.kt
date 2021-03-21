package com.depo.bookstoreclient.domain.usecase

import com.depo.bookstoreclient.data.model.MainList
import com.depo.bookstoreclient.data.model.book.Book
import com.depo.bookstoreclient.domain.repository.BookRepository

class UpdateBooksUseCase(private val bookRepository: BookRepository) {
    suspend fun execute(): MainList? = bookRepository.updateBooks()
}