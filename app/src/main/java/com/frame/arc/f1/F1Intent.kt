package com.frame.arc.f1

sealed class F1Intent {
    object GetBannerData : F1Intent()
    /*you can write other intent*/
}

sealed class F1State {
    object showLoading : F1State()
    /*you can write other state*/
}
