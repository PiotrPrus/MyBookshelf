package com.piotrprus.mybookshelf.common.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(
    @PrimaryKey val isbnNumber: String = "",
    val title: String = "",
    val author: String = "",
    val pages: Int = 0,
    val rating: Int = 0
)