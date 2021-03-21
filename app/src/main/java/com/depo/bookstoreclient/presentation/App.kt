package com.depo.bookstoreclient.presentation

import android.app.Application
import com.depo.bookstoreclient.BuildConfig
import com.depo.bookstoreclient.presentation.di.Injector
import com.depo.bookstoreclient.presentation.di.book.BookSubComponent
import com.depo.bookstoreclient.presentation.di.core.*

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule())
            .build()
    }

    override fun createBookSubComponent(): BookSubComponent {
        return appComponent.bookSubComponent().create()
    }
}