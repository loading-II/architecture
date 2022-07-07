package com.frame.arc.ui.activity

import android.os.Bundle
import android.os.Looper
import androidx.viewbinding.ViewBinding

abstract class BaseViewBindingActivity<D : ViewBinding> : BaseActivity() {
    protected lateinit var mViewBinding: D

    protected fun getViewBinding() = mViewBinding
    protected abstract fun onViewBinding(): D
    protected abstract fun onListener()
    protected abstract fun onLoadData(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        mViewBinding = onViewBinding()
        setContentView(mViewBinding.root)
        Looper.myQueue().addIdleHandler {
            onListener()
            onLoadData(savedInstanceState)
            false
        }
    }



}