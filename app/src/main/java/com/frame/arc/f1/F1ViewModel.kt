package com.frame.arc.f1

import com.frame.arc.vm.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.MutableSharedFlow

class F1ViewModel : BaseViewModel() {

    val mF1Intent = Channel<F1Intent>(Channel.UNLIMITED)
    val mXDataState = MutableSharedFlow<F1State>()

    override fun bindIntent() {
        launch {
           mF1Intent.consumeAsFlow().collect {
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