package com.piotrprus.mybookshelf.common.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Book(
    @PrimaryKey val isbnNumber: String = "",
    val title: String = "",
    val author: String = "",
    val pages: Int = 0,
    val rating: Int = 0
): Parcelable