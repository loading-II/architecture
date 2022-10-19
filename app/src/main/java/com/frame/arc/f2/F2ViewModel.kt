package com.frame.arc.f2

import com.frame.arc.vm.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.MutableSharedFlow

class F2ViewModel : BaseViewModel() {

    val mF2Intent = Channel<F2Intent>(Channel.UNLIMITED)
    val mXDataState = MutableSharedFlow<F2State>()

    override fun bindIntent() {
        launch {
           mF2Intent.consumeAsFlow().collect {
               when (it) {
                    /* simple code
                    is HomeIntent.GetBannerData -> {
                         getRepoBannerData()
                    }*/
                }
           }
        }
    }

}