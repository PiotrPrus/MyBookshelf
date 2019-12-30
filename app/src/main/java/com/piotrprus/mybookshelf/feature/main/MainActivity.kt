package com.piotrprus.mybookshelf.feature.main

import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import com.google.android.material.bottomappbar.BottomAppBar
import com.piotrprus.mybookshelf.R
import com.piotrprus.mybookshelf.base.BaseVMActivity
import com.piotrprus.mybookshelf.base.LayoutResId
import com.piotrprus.mybookshelf.common.utils.event.emit
import com.piotrprus.mybookshelf.databinding.ActivityMainBinding

@LayoutResId(R.layout.activity_main)
class MainActivity
    : BaseVMActivity<MainSharedViewModel, ActivityMainBinding>(MainSharedViewModel::class) {

    override fun start() {
        super.start()
        binding.viewModel = viewModel
        setSupportActionBar(binding.mainBottomAppBar)
        setupNavigation()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.book_detail_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.deleteBook -> viewModel.deleteBookEvent.emit()
            R.id.clearForm -> viewModel.clearFormEvent.emit()
        }
        return true
    }

    private fun setupNavigation() {
        val navController = findNavController(R.id.fragmentHost)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.bookListFragment -> positionFabListView()
                R.id.bookDetailFragment -> positionFabDetailView()
            }
        }
    }

    private fun positionFabDetailView() {
        binding.mainBottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
        binding.mainFAB.setImageResource(R.drawable.ic_check_24px)
    }

    private fun positionFabListView() {
        binding.mainBottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
        binding.mainFAB.setImageResource(R.drawable.ic_add_24px)
    }
}
