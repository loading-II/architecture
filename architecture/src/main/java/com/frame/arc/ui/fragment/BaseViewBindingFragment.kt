package com.frame.arc.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

open abstract class BaseViewBindingFragment<D : ViewBinding> : BaseFragment() {

    protected lateinit var mViewBinding: D
    protected abstract fun getViewBinding(): D

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mViewBinding = getViewBinding()
        return mViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onListener()
        onLoadData()
    }

    protected abstract fun onListener()
    protected abstract fun onLoadData()





}