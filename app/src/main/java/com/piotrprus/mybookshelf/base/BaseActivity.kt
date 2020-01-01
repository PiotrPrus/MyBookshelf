package com.piotrprus.mybookshelf.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.piotrprus.mybookshelf.common.utils.event.Event
import com.piotrprus.mybookshelf.common.utils.event.EventObserver

abstract class BaseActivity<VDB : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var binding: VDB
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (this::class.annotations
            .filterIsInstance(LayoutResId::class.java)
            .firstOrNull())
            ?.let {
                binding = DataBindingUtil.setContentView(this, it.resId)
                binding.setLifecycleOwner(this)
            }
        start()
    }

    open fun start() {}

    fun <T> LiveData<T>.observe(observe: ((value: T?) -> Unit)) {
        this.observe(this@BaseActivity, Observer { value -> observe(value) })
    }

    fun <T> LiveData<Event<T>>.observeEvent(observe: ((value: T?) -> Unit)) {
        this.observe(this@BaseActivity, EventObserver { value -> observe(value) })
    }
}