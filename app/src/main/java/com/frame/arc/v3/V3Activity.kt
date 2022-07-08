package com.frame.arc.v3

import android.os.Bundle
import kotlinx.coroutines.flow.collect
import androidx.lifecycle.lifecycleScope
import com.frame.arc.R
import com.frame.arc.databinding.XActivityV3Binding
import kotlinx.coroutines.flow.distinctUntilChanged
import com.frame.arc.ui.activity.BaseViewDataBindingActivity


 /*
  *  @文件名:   V3Activity
  *  @描述：    TODO: 类描述
  */
class V3Activity : BaseViewDataBindingActivity<XActivityV3Binding>(R.layout.x_activity_v3){

    private val mViewModel: V3ViewModel by lazy { getActivityScopeViewModel(V3ViewModel::class.java) }

    override fun onListener() {
            lifecycleScope.launchWhenCreated {
                            mViewModel.mXDataState.distinctUntilChanged().collect {
                                when (it) {
                                    is V3State.showLoading -> {}
                                }
                            }
            }
    }

    override fun onLoadData(savedInstanceState: Bundle?) {
        with(getViewDataBinding()){
            presenter = this@V3Activity
            vm = mViewModel
        }
        doLaunch { mViewModel.mV3Intent.send(V3Intent.GetBannerData) }
    }




}
