package com.piotrprus.mybookshelf.feature.bookDetail

import com.piotrprus.mybookshelf.R
import com.piotrprus.mybookshelf.base.BaseVMFragment
import com.piotrprus.mybookshelf.base.LayoutResId
import com.piotrprus.mybookshelf.databinding.FragmentBookDetailBinding

@LayoutResId(R.layout.fragment_book_detail)
class BookDetailFragment
    : BaseVMFragment<BookDetailViewModel, FragmentBookDetailBinding>(BookDetailViewModel::class) {

    override fun start() {
        binding.viewModel = viewModel
    }
}