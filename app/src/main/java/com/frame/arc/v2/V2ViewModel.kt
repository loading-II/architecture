package com.frame.arc.v2

import com.frame.arc.vm.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.MutableSharedFlow

class V2ViewModel : BaseViewModel() {

    val mV2Intent = Channel<V2Intent>(Channel.UNLIMITED)
    val mXDataState = MutableSharedFlow<V2State>()

    override fun bindIntent() {
        launch {
           mV2Intent.consumeAsFlow().collect {
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