package com.frame.arc.f1

import android.os.Bundle
import kotlinx.coroutines.flow.collect
import androidx.lifecycle.lifecycleScope
import com.frame.arc.databinding.ZyFragmentF1Binding
import kotlinx.coroutines.flow.distinctUntilChanged
import com.frame.arc.ui.fragment.BaseViewBindingFragment

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
    * @文件名:   F1Fragment
    * @描述：    TODO: 类描述
    */
class F1Fragment : BaseViewBindingFragment<ZyFragmentF1Binding>() {

    companion object {//实例
        fun newInstance(args: Bundle? = null): F1Fragment {
            return F1Fragment().apply { args?.let { arguments = it } }
        }
    }

    override fun onViewBinding() = ZyFragmentF1Binding.inflate(layoutInflater)
    private val mViewModel: F1ViewModel by lazy { getFragmentScopeViewModel(F1ViewModel::class.java) }

    override fun initArgs(bundle: Bundle) {}

    override fun onListener() {
        lifecycleScope.launchWhenCreated {
                        mViewModel.mXDataState.distinctUntilChanged().collect {
                            when (it) {
                                is F1State.showLoading -> {}
                            }
                        }
        }
    }

    override fun onLoadData() {
        doLaunch { mViewModel.mF1Intent.send(F1Intent.GetBannerData) }
    }





}
