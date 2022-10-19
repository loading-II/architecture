package com.frame.arc.f2

import android.os.Bundle
import kotlinx.coroutines.flow.collect
import androidx.lifecycle.lifecycleScope
import com.frame.arc.R
import com.frame.arc.databinding.ZyFragmentF2Binding
import kotlinx.coroutines.flow.distinctUntilChanged
import com.frame.arc.ui.fragment.BaseViewDataBindingFragment


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
   * @文件名:    F2Fragment
   * @描述：    TODO: 类描述
   */
class F2Fragment : BaseViewDataBindingFragment<ZyFragmentF2Binding>(R.layout.zy_fragment_f2){

    companion object {//实例
        fun newInstance(args: Bundle? = null): F2Fragment {
            return F2Fragment().apply {args?.let {arguments = it}}
        }
    }

    private val mViewModel: F2ViewModel by lazy { getFragmentScopeViewModel(F2ViewModel::class.java) }

    override fun initArgs(bundle: Bundle) {}

    override fun onListener() {
        lifecycleScope.launchWhenCreated {
                        mViewModel.mXDataState.distinctUntilChanged().collect {
                            when (it) {
                                is F2State.showLoading -> {}
                            }
                        }
        }
    }

    override fun onLoadData() {
        with(getViewDataBinding()){
            presenter = this@F2Fragment
            vm = mViewModel
        }
        doLaunch { mViewModel.mF2Intent.send(F2Intent.GetBannerData) }
    }





}
