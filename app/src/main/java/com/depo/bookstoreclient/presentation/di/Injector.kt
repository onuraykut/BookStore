package com.depo.bookstoreclient.presentation.di

import com.depo.bookstoreclient.presentation.di.book.BookSubComponent

interface Injector {
    fun createBookSubComponent():BookSubComponent
}