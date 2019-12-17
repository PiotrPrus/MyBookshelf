package com.piotrprus.mybookshelf.common.di

import com.piotrprus.mybookshelf.feature.bookDetail.BookDetailViewModel
import com.piotrprus.mybookshelf.feature.bookList.BookListViewModel
import com.piotrprus.mybookshelf.feature.main.MainSharedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainSharedViewModel() }
    viewModel { BookListViewModel() }
    viewModel { BookDetailViewModel(get()) }
}