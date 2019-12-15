package com.piotrprus.mybookshelf.feature.main

import com.piotrprus.mybookshelf.R
import com.piotrprus.mybookshelf.base.BaseVMActivity
import com.piotrprus.mybookshelf.base.LayoutResId
import com.piotrprus.mybookshelf.databinding.ActivityMainBinding

@LayoutResId(R.layout.activity_main)
class MainActivity
    : BaseVMActivity<MainSharedViewModel, ActivityMainBinding>(MainSharedViewModel::class) {

    override fun start() {
        super.start()
        binding.viewModel = viewModel
    }
}
