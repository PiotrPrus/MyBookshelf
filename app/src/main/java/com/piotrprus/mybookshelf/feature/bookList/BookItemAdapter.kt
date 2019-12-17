package com.piotrprus.mybookshelf.feature.bookList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.piotrprus.mybookshelf.R
import com.piotrprus.mybookshelf.common.data.model.Book
import com.piotrprus.mybookshelf.databinding.ItemBookBinding

private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Book>() {
    override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean =
        oldItem.isbnNumber == newItem.isbnNumber

    override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean =
        oldItem == newItem
}

class BookItemAdapter(private val onClickListener: (Book) -> Unit) :
    ListAdapter<Book, BookItemViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookItemViewHolder {
        val binding: ItemBookBinding = DataBindingUtil
            .inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_book, parent, false
            )
        return BookItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookItemViewHolder, position: Int) {
        val book = getItem(position)
        holder.itemView.setOnClickListener { onClickListener(book) }
        holder.bind(book)
    }
}