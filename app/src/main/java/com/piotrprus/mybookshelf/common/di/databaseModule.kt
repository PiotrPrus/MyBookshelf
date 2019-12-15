package com.piotrprus.mybookshelf.common.di

import androidx.room.Room
import com.piotrprus.mybookshelf.common.data.db.MyBookshelfDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(get(), MyBookshelfDatabase::class.java, "bookshelf_db")
            .build()
    }
    single { get<MyBookshelfDatabase>().bookDao() }

}