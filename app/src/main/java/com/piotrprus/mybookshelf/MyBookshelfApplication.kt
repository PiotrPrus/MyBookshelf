package com.piotrprus.mybookshelf

import android.app.Application
import com.piotrprus.mybookshelf.common.di.databaseModule
import com.piotrprus.mybookshelf.common.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class MyBookshelfApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyBookshelfApplication)
            modules(listOf(viewModelModule, databaseModule))
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}