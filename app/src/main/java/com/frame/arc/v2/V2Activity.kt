package com.frame.arc.v2

import android.os.Bundle
import kotlinx.coroutines.flow.collect
import androidx.lifecycle.lifecycleScope
import com.frame.arc.R
import com.frame.arc.databinding.ZyActivityV2Binding
import kotlinx.coroutines.flow.distinctUntilChanged
import com.frame.arc.ui.activity.BaseViewDataBindingActivity



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
     * @文件名:    V2Activity
     * @描述：    TODO: 类描述
     */
class V2Activity : BaseViewDataBindingActivity<ZyActivityV2Binding>(R.layout.zy_activity_v2){

    private val mViewModel: V2ViewModel by lazy { getActivityScopeViewModel(V2ViewModel::class.java) }

    override fun onListener() {
            lifecycleScope.launchWhenCreated {
                            mViewModel.mXDataState.distinctUntilChanged().collect {
                                when (it) {
                                    is V2State.showLoading -> {}
                                }
                            }
            }
    }

    override fun onLoadData(savedInstanceState: Bundle?) {
        with(getViewDataBinding()){
            presenter = this@V2Activity
            vm = mViewModel
        }
        doLaunch { mViewModel.mV2Intent.send(V2Intent.GetBannerData) }

    }




}
