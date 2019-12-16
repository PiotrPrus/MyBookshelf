package com.piotrprus.mybookshelf


import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.piotrprus.mybookshelf.common.data.db.MyBookshelfDatabase
import org.koin.dsl.module

val roomTestModule = module {
    single { ApplicationProvider.getApplicationContext<Context>() as Context }
    single {
        Room.inMemoryDatabaseBuilder(get(), MyBookshelfDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }
    single { get<MyBookshelfDatabase>().bookDao() }
}

val testModules = listOf(roomTestModule)
