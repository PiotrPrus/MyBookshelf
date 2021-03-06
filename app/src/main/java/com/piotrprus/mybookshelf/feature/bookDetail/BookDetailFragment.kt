package com.piotrprus.mybookshelf.feature.bookDetail

import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.piotrprus.mybookshelf.R
import com.piotrprus.mybookshelf.base.BaseVMFragment
import com.piotrprus.mybookshelf.base.LayoutResId
import com.piotrprus.mybookshelf.common.data.model.Book
import com.piotrprus.mybookshelf.databinding.FragmentBookDetailBinding
import com.piotrprus.mybookshelf.feature.main.MainSharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

@LayoutResId(R.layout.fragment_book_detail)
class BookDetailFragment
    : BaseVMFragment<BookDetailViewModel, FragmentBookDetailBinding>(BookDetailViewModel::class) {

    private val mainSharedViewModel: MainSharedViewModel by sharedViewModel()
    private val bookArgument: Book? by lazy {
        BookDetailFragmentArgs.fromBundle(requireArguments()).book
    }


    override fun start() {
        binding.viewModel = viewModel
        bookArgument?.let { viewModel.setBook(it) }
        viewModel.apply {
            navigateToBookListEvent.observeEvent {
                findNavController().navigate(R.id.action_bookDetailFragment_to_bookListFragment)
            }
            showErrorSnackbarEvent.observeEvent { msg -> showSnackbar(msg) }
            bookMediatorLD.observe { }
        }
        mainSharedViewModel.apply {
            mainFabClickEvent.observeEvent {
                viewModel.onConfirmationClicked()
            }
            deleteBookEvent.observeEvent { viewModel.deleteBook() }
            clearFormEvent.observeEvent { viewModel.clearForm() }
        }
    }

    private fun showSnackbar(msg: String) {
        Snackbar.make(binding.root, msg, Snackbar.LENGTH_SHORT)
            .setAnchorView(requireActivity().findViewById<FloatingActionButton>(R.id.mainFAB))
            .show()
    }
}