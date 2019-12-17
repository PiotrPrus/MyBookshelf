package com.piotrprus.mybookshelf.feature.main

import androidx.lifecycle.ViewModel
import com.piotrprus.mybookshelf.common.utils.event.EventEmitter
import com.piotrprus.mybookshelf.common.utils.event.emit

class MainSharedViewModel: ViewModel() {

    val mainFabClickEvent = EventEmitter()
    val deleteBookEvent = EventEmitter()
    val clearFormEvent = EventEmitter()

    fun onMainFabClicked() {
        mainFabClickEvent.emit()
    }
}