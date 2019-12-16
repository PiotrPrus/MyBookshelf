package com.piotrprus.mybookshelf.common.data.repository

import com.piotrprus.mybookshelf.common.data.db.BookDao
import com.piotrprus.mybookshelf.common.data.model.Book
import com.piotrprus.mybookshelf.common.utils.ISBNValidator

class BookRepository(private val bookDao: BookDao) {
    suspend fun addBook(book: Book) {
        if (ISBNValidator.isISBNValid(book.isbnNumber)) {
            bookDao.insert(book)
        } else {
            throw Exception("ISBN number is not valid")
        }
    }

    suspend fun updateBook(book: Book) {
        if (ISBNValidator.isISBNValid(book.isbnNumber)) {
            bookDao.update(book)
        } else {
            throw Exception("ISBN number is not valid")
        }
    }

    suspend fun removeBook(book: Book) = bookDao.delete(book)
    suspend fun getAll() = bookDao.getAll()
}