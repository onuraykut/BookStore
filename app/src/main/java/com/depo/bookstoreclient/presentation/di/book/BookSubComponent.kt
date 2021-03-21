package com.depo.bookstoreclient.presentation.di.book

import com.depo.bookstoreclient.presentation.book.BookActivity
import dagger.Subcomponent

@BookScope
@Subcomponent(modules = [BookModule::class])
interface BookSubComponent {
    fun inject(bookActivity: BookActivity)
    @Subcomponent.Factory
    interface Factory{
        fun create():BookSubComponent
    }
}