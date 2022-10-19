package com.frame.arc.f2

sealed class F2Intent {
    object GetBannerData : F2Intent()
    /*you can write other intent*/
}

sealed class F2State {
    object showLoading : F2State()
    /*you can write other state*/
}
