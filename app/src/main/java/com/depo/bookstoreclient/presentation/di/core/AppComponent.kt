package com.depo.bookstoreclient.presentation.di.core

import com.depo.bookstoreclient.presentation.di.book.BookSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DataBaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {
    fun bookSubComponent(): BookSubComponent.Factory
}