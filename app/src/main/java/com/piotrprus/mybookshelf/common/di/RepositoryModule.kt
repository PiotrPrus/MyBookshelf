package com.piotrprus.mybookshelf.common.di

import com.piotrprus.mybookshelf.common.data.repository.BookRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { BookRepository(get()) }
}