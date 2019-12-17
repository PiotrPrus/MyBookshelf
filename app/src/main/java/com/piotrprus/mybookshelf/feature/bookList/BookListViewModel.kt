package com.piotrprus.mybookshelf.feature.bookList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piotrprus.mybookshelf.common.data.model.Book
import com.piotrprus.mybookshelf.common.data.repository.BookRepository
import kotlinx.coroutines.launch

class BookListViewModel(private val repository: BookRepository) : ViewModel() {

    val books = MutableLiveData<List<Book>>()

    init {
        getAllBooksFromDB()
    }

    private fun getAllBooksFromDB() {
        viewModelScope.launch {
            val result = repository.getAll()
            books.value = result
        }
    }
}