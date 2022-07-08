package com.frame.arc.v3

import com.frame.arc.vm.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.MutableSharedFlow

class V3ViewModel : BaseViewModel() {

    val mV3Intent = Channel<V3Intent>(Channel.UNLIMITED)
    val mXDataState = MutableSharedFlow<V3State>()

    override fun bindIntent() {
        launch {
           mV3Intent.consumeAsFlow().collect {
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