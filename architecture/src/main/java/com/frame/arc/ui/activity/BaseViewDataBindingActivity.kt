package com.frame.arc.ui.activity

import android.os.Bundle
import android.os.Looper
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.frame.arc.callback.Presenter

open abstract class BaseViewDataBindingActivity<VB : ViewDataBinding> constructor(private val layout: Int) : BaseActivity(), Presenter.SimplePresenter {

    private lateinit var mViewDataBinding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView()
        Looper.myQueue().addIdleHandler {
            onListener()
            onLoadData(savedInstanceState)
            false
        }
    }

    private fun bindView() {
        mViewDataBinding = DataBindingUtil.setContentView<VB>(this, layout)
        mViewDataBinding.executePendingBindings()
        mViewDataBinding.lifecycleOwner = this
    }

    protected fun getViewDataBinding(): VB {
        return mViewDataBinding
    }
    protected abstract fun onListener()
    protected abstract fun onLoadData(savedInstanceState: Bundle?)


}