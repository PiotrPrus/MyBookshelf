package com.piotrprus.mybookshelf.common.extensions

fun String.toListOfDigits(): List<Int>{
    return this.toCharArray().map { it.toString().toInt() }
}