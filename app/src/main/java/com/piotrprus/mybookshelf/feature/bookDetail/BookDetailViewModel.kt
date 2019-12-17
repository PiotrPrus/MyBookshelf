package com.piotrprus.mybookshelf.feature.bookDetail

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piotrprus.mybookshelf.common.data.model.Book
import com.piotrprus.mybookshelf.common.data.repository.BookRepository
import com.piotrprus.mybookshelf.common.utils.event.DataEventEmitter
import com.piotrprus.mybookshelf.common.utils.event.EventEmitter
import com.piotrprus.mybookshelf.common.utils.event.emit
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class BookDetailViewModel(private val bookRepository: BookRepository) : ViewModel() {

    val bookTitle = MutableLiveData<String>()
    val bookAuthor = MutableLiveData<String>()
    val bookISBN = MutableLiveData<String>()
    val bookPages = MutableLiveData<String>()
    val bookRating = MutableLiveData<Float>()
    val bookMediatorLD = MediatorLiveData<Book>()
    val showErrorSnackbarEvent = DataEventEmitter<String>()
    val navigateToBookListEvent = EventEmitter()

    init {
        setupBookMediatorLD()
    }

    private fun setupBookMediatorLD() {
        bookMediatorLD.value = Book()
        bookMediatorLD.addSource(bookTitle) {
            bookMediatorLD.value = bookMediatorLD.value?.copy(title = it)
        }
        bookMediatorLD.addSource(bookAuthor) {
            bookMediatorLD.value = bookMediatorLD.value?.copy(author = it)
        }
        bookMediatorLD.addSource(bookISBN) {
            bookMediatorLD.value = bookMediatorLD.value?.copy(isbnNumber = it)
        }
        bookMediatorLD.addSource(bookPages) {
            bookMediatorLD.value = bookMediatorLD.value?.copy(pages = it.toInt())
        }
        bookMediatorLD.addSource(bookRating) {
            bookMediatorLD.value = bookMediatorLD.value?.copy(rating = it.roundToInt())
        }

    }

    fun onConfirmationClicked() {
        bookMediatorLD.value?.let { book ->
            viewModelScope.launch {
                try {
                    bookRepository.addBook(book)
                    navigateToBookListEvent.emit()
                } catch (e: Exception) {
                    showErrorSnackbarEvent.emit(e.localizedMessage ?: "Failed to add book")
                }
            }
        }
    }

    fun setBook(book: Book) {
        bookTitle.value = book.title
        bookAuthor.value = book.author
        bookISBN.value = book.isbnNumber
        bookPages.value = book.pages.toString()
        bookRating.value = book.rating.toFloat()
    }
}