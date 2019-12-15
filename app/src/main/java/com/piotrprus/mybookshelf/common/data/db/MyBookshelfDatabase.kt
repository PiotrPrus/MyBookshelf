package com.piotrprus.mybookshelf.common.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.piotrprus.mybookshelf.common.data.model.Book

@Database(entities = [Book::class], version = 1)
abstract class MyBookshelfDatabase: RoomDatabase() {
    abstract fun bookDao(): BookDao
}