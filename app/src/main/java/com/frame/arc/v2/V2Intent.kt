package com.frame.arc.v2

sealed class V2Intent {
    object GetBannerData : V2Intent()
    /*you can write other intent*/
}

sealed class V2State {
    object showLoading : V2State()
    /*you can write other state*/
}
