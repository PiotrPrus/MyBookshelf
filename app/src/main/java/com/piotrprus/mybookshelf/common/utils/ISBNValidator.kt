package com.piotrprus.mybookshelf.common.utils

import com.piotrprus.mybookshelf.common.extensions.toListOfDigits

object ISBNValidator {
    fun isISBNValid(isbn: String): Boolean {
        return when {
            isbn.firstOrNull { !it.isDigit() } != null -> false
            isbn.length == 10 -> validate10digitISBN(isbn)
            isbn.length == 13 -> validate13digitISBN(isbn)
            else -> false
        }
    }

    // I found this check at: https://www.instructables.com/id/How-to-verify-a-ISBN/
    private fun validate13digitISBN(isbn: String): Boolean {
        var sum = 0
        isbn.toListOfDigits().forEachIndexed { index, value ->
            sum = if (index % 2 == 0) sum.plus(value)
            else sum.plus(value.times(3))
        }
        return sum % 10 == 0
    }

    // I found this check at: https://www.instructables.com/id/How-to-verify-a-ISBN/
    private fun validate10digitISBN(isbn: String): Boolean {
        var sum = 0
        isbn.toListOfDigits().forEachIndexed { index, value ->
            sum = sum.plus(value.times(isbn.length.minus(index)))
        }
        return sum % 11 == 0
    }
}