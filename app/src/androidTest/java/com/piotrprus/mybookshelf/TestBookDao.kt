package com.piotrprus.mybookshelf

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.piotrprus.mybookshelf.common.data.db.BookDao
import com.piotrprus.mybookshelf.common.data.db.MyBookshelfDatabase
import com.piotrprus.mybookshelf.common.data.model.Book
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import timber.log.Timber

@RunWith(AndroidJUnit4::class)
class TestBookDao : KoinTest {

    private val database by inject<MyBookshelfDatabase>()
    private val dao by inject<BookDao>()

    @Before
    fun before() {
        stopKoin()
        startKoin {
            modules(testModules) }
    }

    @After
    fun after() {
        database.close()
        stopKoin()
    }

    @Test
    fun createAndGetBookTest() {
        val book = Book(1234567890123, "Potop", "Henryk Sienkiewicz", 500, 4)

        runBlocking {
            dao.insert(book)
            val bookFromDb = dao.fetchAll()
            Assert.assertEquals(listOf(book), bookFromDb)
        }
    }

    @Test
    fun createAndUpdateBookTest() {
        val book = Book(1234567890123, "Potop", "Henryk Sienkiewicz", 500, 4)

        runBlocking {
            dao.insert(book)
            val updatedBook = book.copy(pages = 100)
            dao.update(updatedBook)
            val bookFromDb = dao.fetchAll()
            Timber.d("originalBook: $book, book from DB: $bookFromDb")
            Assert.assertNotEquals(listOf(book), bookFromDb)
        }
    }
}