package com.frame.arc.v1

import android.os.Bundle
import kotlinx.coroutines.flow.collect
import androidx.lifecycle.lifecycleScope
import com.frame.arc.databinding.ZyActivityV1Binding
import kotlinx.coroutines.flow.distinctUntilChanged
import com.frame.arc.ui.activity.BaseViewBindingActivity


 /**
   * ----------Dragon be here!----------/
   * 　　 ┏┓　 ┏┓
   * 　　┏┛┻━━━┛┻┓━━━
   * 　　┃　　　　　 ┃
   * 　　┃　　　━　  ┃
   * 　　┃　┳┛　┗┳
   * 　　┃　　　　　 ┃
   * 　　┃　　　┻　  ┃
   * 　　┃　　　　   ┃
   * 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
   * 　　　　┃　　　┃    神兽保佑,代码无bug
   * 　　　　┃　　　┃
   * 　　　　┃　　　┗━━━┓
   * 　　　　┃　　　　　　┣┓
   * 　　　　┃　　　　　　　┏┛
   * 　　　　┗┓┓┏━┳┓┏┛━━━━━
   * 　　　　　┃┫┫　┃┫┫
   * 　　　　　┗┻┛　┗┻┛
   * ━━━━━━━━━━━神兽出没━━━━━━━━━━━━━━
   * @文件名:   V1Activity
   * @描述：    TODO: 类描述
   */
class V1Activity : BaseViewBindingActivity<ZyActivityV1Binding>() {

    override fun onViewBinding() = ZyActivityV1Binding.inflate(layoutInflater)
    private val mViewModel: V1ViewModel by lazy { getActivityScopeViewModel(V1ViewModel::class.java) }

    override fun onListener() {
        lifecycleScope.launchWhenCreated {
                mViewModel.mXDataState.distinctUntilChanged().collect {
                    when (it) {
                        is V1State.showLoading -> {}
                    }
                }
        }
    }

    override fun onLoadData(savedInstanceState: Bundle?) {
        doLaunch { mViewModel.mV1Intent.send(V1Intent.GetBannerData) }
    }





}
