package com.piotrprus.mybookshelf.feature.bookList

import androidx.navigation.fragment.findNavController
import com.piotrprus.mybookshelf.R
import com.piotrprus.mybookshelf.base.BaseVMFragment
import com.piotrprus.mybookshelf.base.LayoutResId
import com.piotrprus.mybookshelf.databinding.FragmentBookListBinding
import com.piotrprus.mybookshelf.feature.main.MainSharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

@LayoutResId(R.layout.fragment_book_list)
class BookListFragment
    : BaseVMFragment<BookListViewModel, FragmentBookListBinding>(BookListViewModel::class) {

    private val mainSharedViewModel: MainSharedViewModel by sharedViewModel()

    override fun start() {
        binding.viewModel = viewModel
        mainSharedViewModel.mainFabClickEvent.observeEvent {
            findNavController().navigate(R.id.bookDetailFragment)
        }
    }
}