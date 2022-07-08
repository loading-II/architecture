package com.frame.arc.v2

import android.os.Bundle
import kotlinx.coroutines.flow.collect
import androidx.lifecycle.lifecycleScope
import com.frame.arc.databinding.XFragmentV2Binding
import kotlinx.coroutines.flow.distinctUntilChanged
import com.frame.arc.ui.fragment.BaseViewBindingFragment

 /*
  *  @文件名:   V2Fragment
  *  @描述：    TODO: 类描述
  */
class V2Fragment : BaseViewBindingFragment<XFragmentV2Binding>() {

    companion object {//实例
        fun newInstance(args: Bundle? = null): V2Fragment {
            return V2Fragment().apply { args?.let { arguments = it } }
        }
    }

    override fun getViewBinding() = XFragmentV2Binding.inflate(layoutInflater)
    private val mViewModel: V2ViewModel by lazy { getFragmentScopeViewModel(V2ViewModel::class.java) }

    override fun initArgs(bundle: Bundle) {}

    override fun onListener() {
        lifecycleScope.launchWhenCreated {
                        mViewModel.mXDataState.distinctUntilChanged().collect {
                            when (it) {
                                is V2State.showLoading -> {}
                            }
                        }
        }
    }

    override fun onLoadData() {
        doLaunch { mViewModel.mV2Intent.send(V2Intent.GetBannerData) }
    }





}
