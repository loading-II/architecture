package com.frame.arc.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

open abstract class BaseViewDataBindingFragment<VB : ViewDataBinding> constructor(private val layoutID: Int) : BaseFragment() {

    private lateinit var mViewDataBinding: VB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        mViewDataBinding = DataBindingUtil.inflate(inflater, layoutID, container, false);
        mViewDataBinding.lifecycleOwner = this
        return mViewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onListener()
        onLoadData()
    }

    fun getViewDataBinding(): VB {
        return mViewDataBinding
    }

    protected abstract fun onListener()
    protected abstract fun onLoadData()

}