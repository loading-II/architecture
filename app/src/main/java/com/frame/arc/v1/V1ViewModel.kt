package com.frame.arc.v1

import com.frame.arc.vm.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.MutableSharedFlow

class V1ViewModel : BaseViewModel() {

    val mV1Intent = Channel<V1Intent>(Channel.UNLIMITED)
    val mXDataState = MutableSharedFlow<V1State>()

    override fun bindIntent() {
        launch {
           mV1Intent.consumeAsFlow().collect {
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