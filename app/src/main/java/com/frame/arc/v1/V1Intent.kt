package com.frame.arc.v1

sealed class V1Intent {
    object GetBannerData : V1Intent()
    /*you can write other intent*/
}

sealed class V1State {
    object showLoading : V1State()
    /*you can write other state*/
}
