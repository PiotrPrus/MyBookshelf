package com.piotrprus.mybookshelf.common.data.db

import androidx.room.Dao
import androidx.room.Query
import com.piotrprus.mybookshelf.base.BaseDao
import com.piotrprus.mybookshelf.common.data.model.Book

@Dao
interface BookDao: BaseDao<Book> {
    @Query("DELETE FROM book")
    suspend fun deleteAll()
    @Query("SELECT * FROM book")
    suspend fun getAll(): List<Book>
}