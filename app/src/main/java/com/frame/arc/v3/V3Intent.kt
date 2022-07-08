package com.frame.arc.v3

sealed class V3Intent {
    object GetBannerData : V3Intent()
    /*you can write other intent*/
}

sealed class V3State {
    object showLoading : V3State()
    /*you can write other state*/
}
