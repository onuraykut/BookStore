package com.depo.bookstoreclient.presentation.di.core

import android.content.Context
import com.depo.bookstoreclient.presentation.di.book.BookSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [BookSubComponent::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }
}