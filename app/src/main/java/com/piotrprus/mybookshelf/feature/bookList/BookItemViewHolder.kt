package com.piotrprus.mybookshelf.feature.bookList

import androidx.recyclerview.widget.RecyclerView
import com.piotrprus.mybookshelf.common.data.model.Book
import com.piotrprus.mybookshelf.databinding.ItemBookBinding

class BookItemViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(book: Book) {
        binding.itemTitle.text = book.title
        binding.itemAuthor.text = book.author
        binding.itemRatingTV.text = book.rating.toString()
    }
}