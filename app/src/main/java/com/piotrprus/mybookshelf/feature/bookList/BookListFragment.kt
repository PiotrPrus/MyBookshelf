package com.piotrprus.mybookshelf.feature.bookList

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.piotrprus.mybookshelf.R
import com.piotrprus.mybookshelf.base.BaseVMFragment
import com.piotrprus.mybookshelf.base.LayoutResId
import com.piotrprus.mybookshelf.common.data.model.Book
import com.piotrprus.mybookshelf.databinding.FragmentBookListBinding
import com.piotrprus.mybookshelf.feature.main.MainSharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

@LayoutResId(R.layout.fragment_book_list)
class BookListFragment
    : BaseVMFragment<BookListViewModel, FragmentBookListBinding>(BookListViewModel::class) {

    private val mainSharedViewModel: MainSharedViewModel by sharedViewModel()

    private val onBookClicked: (Book) -> Unit = { book ->
        findNavController().navigate(
            BookListFragmentDirections.actionBookListFragmentToBookDetailFragment(
                book
            )
        )
    }

    override fun start() {
        binding.viewModel = viewModel
        mainSharedViewModel.mainFabClickEvent.observeEvent {
            findNavController().navigate(R.id.bookDetailFragment)
        }
        val adapter = BookItemAdapter(onBookClicked)
        binding.bookRV.apply {
            this.adapter = adapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
        viewModel.books.observe {
            adapter.submitList(it)
        }
    }
}