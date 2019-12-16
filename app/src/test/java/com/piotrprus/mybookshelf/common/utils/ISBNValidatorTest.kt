package com.piotrprus.mybookshelf.common.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class ISBNValidatorTest {

    @Test
    fun isISBNValid() {
        val correct10DigitsISBN = "8304036339"
        val correct10DigitsISBNStartWithZero = "0716703440"
        val wrong10DigitsISBN = "8304046339"
        val correct13DigitsISBN = "9788373272255"
        val wrong13DigitsISBN = "9788375272255"
        val wrongLengthISBN = "123"
        val wrongSymbolsISBN = "-9788373272255"

        assertEquals(true, ISBNValidator.isISBNValid(correct10DigitsISBN))
        assertEquals(true, ISBNValidator.isISBNValid(correct10DigitsISBNStartWithZero))
        assertEquals(false, ISBNValidator.isISBNValid(wrong10DigitsISBN))
        assertEquals(true, ISBNValidator.isISBNValid(correct13DigitsISBN))
        assertEquals(false, ISBNValidator.isISBNValid(wrong13DigitsISBN))
        assertEquals(false, ISBNValidator.isISBNValid(wrongLengthISBN))
        assertEquals(false, ISBNValidator.isISBNValid(wrongSymbolsISBN))

    }
}