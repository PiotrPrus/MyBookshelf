package com.piotrprus.mybookshelf.feature.bookList

import com.piotrprus.mybookshelf.R
import com.piotrprus.mybookshelf.base.BaseVMFragment
import com.piotrprus.mybookshelf.base.LayoutResId
import com.piotrprus.mybookshelf.databinding.FragmentBookListBinding

@LayoutResId(R.layout.fragment_book_list)
class BookListFragment
    : BaseVMFragment<BookListViewModel, FragmentBookListBinding>(BookListViewModel::class) {

    override fun start() {
        binding.viewModel = viewModel
    }
}